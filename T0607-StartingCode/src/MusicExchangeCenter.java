import java.util.*;
public class MusicExchangeCenter {
    private List<User> user;
    private List<Song> downloadedSongs;
    private HashMap<String, Float> royalties;
    private TreeSet<Song> songListTree;
    private Pair<Integer, Song> pair;
    private List<Pair<Integer, Song>> aList;

    public MusicExchangeCenter(){
        user = new ArrayList<>();
        downloadedSongs = new ArrayList<>();
        royalties = new HashMap<String, Float>();
        songListTree = new TreeSet<Song>();
        pair = new Pair<Integer, Song>(0,null);
        aList = new ArrayList<>();

    }
    public List<User> onlineUsers(){
        List<User> online = new ArrayList<User>();
        for(User u : user){
            if (u.isOnline()){
                online.add(u);
            }
        }
        return online;
    }
    public List<Song> allAvailableSongs(){
        List<Song> songs = new ArrayList<Song>();
        for(User u : user){
            if (u.isOnline()){
                for (Song s : u.getSongList()){
                    if (!songs.contains(s)){
                        songs.add(s);
                    }
                }
            }
        }
        return songs;
    }
    public User userWithName(String s){
        for(User u : user){
            if (u.getUserName().equals(s)){
                return u;
            }
        }
        return null;
    }
    public void registerUser(User x){
        String name = x.getUserName();
        if (userWithName(name) == null){
            user.add(x);
        }
    }
    public List<Song> availableSongsByArtist(String artist){
        List<Song> artistList = new ArrayList<Song>();
        for (User u : user){
            if (u.isOnline()) {
                for (Song s : u.getSongList()) {
                    if (s.getArtist().contains(artist)) {
                        artistList.add(s);
                    }
                }
            }
        }
        return artistList;
    }

    public Song getSong(String title, String ownerName){
        Song s;
        for (User u : user){
            if(u.isOnline() && u.getUserName().equals(ownerName)){
                s = u.songWithTitle(title);
                if (s != null) {
                    downloadedSongs.add(s);
                    if (!royalties.containsKey(s.getArtist())) {
                        royalties.put(s.getArtist(), 0.25f);
                    }
                    else {
                        float num = royalties.get(s.getArtist());
                        num += 0.25f;
                        royalties.replace(s.getArtist(), num);
                    }
                    return s;

                }
            }
        }
        return null;
    }
    public List<Song> getDownloadedSongs(){
        return downloadedSongs;
    }
    public void displayRoyalties(){//needs correct format atm is just for display
        System.out.println(String.format("%-8s %-7s", "Amount", "Artist"));
        System.out.println("-----------------");

        for(String i: royalties.keySet()){
            if (royalties.get(i) % 0.5 == 0){
                System.out.println(String.format("$%-7s %-7s", royalties.get(i) + "0", i));
            }
            else {
                System.out.println(String.format("$%-7s %-7s", royalties.get(i), i));
            }
        }
    }

    public TreeSet<Song> uniqueDownloads(){
        boolean compare;
        for (Song s: downloadedSongs){
            compare = true;
            for(Song i: songListTree){
                if(s.compareTo(i) == 0) {
                    compare = false;
                    break;
                }
            }
            if (compare){
                songListTree.add(s);
            }
        }
        return songListTree;
    }
    public List<Pair<Integer, Song>> songsByPopularity(){
        for (Song s: uniqueDownloads()){
            int count = 0;
            boolean compare = true;
            for (Song dupe: downloadedSongs){//collects dupes
                if (dupe == s){
                    count += 1;
                }
            }
            if(aList.size() == 0){//to add first item in arraylist, or it won't work
                Pair<Integer, Song> var = new Pair<Integer, Song>(count, s);
                aList.add(var);
            }
            else{
                for (Pair<Integer, Song> p: aList){
                    if (p.getValue() == s){
                        compare = false;
                        break;
                    }
                }
                if (compare){
                    Pair<Integer, Song> var = new Pair<Integer, Song>(count, s);
                    aList.add(var);
                }

            }
        }

        Collections.sort(aList, new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                return (p2.getKey() - p1.getKey());
            }
        });

        return aList;
    }


    public String toString(){
        return "Music Exchange Center (" + onlineUsers().size() + " users online, " + allAvailableSongs().size() + " songs available)";
    }
}
