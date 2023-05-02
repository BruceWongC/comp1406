import java.util.*;
public class User {
  private String     userName;
  private boolean    online;
  private List<Song> songList;

  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList();
  }
  
  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }
  public void addSong(Song s){
    songList.add(s);
    s.setOwner(this);
  }
  public List<Song> getSongList(){
    return songList;
  }

  public int totalSongTime(){
    int output = 0;
    for (Song s : songList){
      output += s.getDuration();
    }

    return output;
  }

  public void register(MusicExchangeCenter m){
    m.registerUser(this);
  }
  public void logon(){
    online = true;
  }
  public void logoff(){
    online = false;
  }

  public List<String> requestCompleteSonglist(MusicExchangeCenter m){//return list with contents of part 3
    List<String> list = new ArrayList<String>();
    list.add(String.format("%-30s %-30s %-30s %-30s", "TITLE" , "ARTIST", "Time" , "OWNER"));

    for (User u : m.onlineUsers()){//when seconds < 10, there is no zero
      for (Song s: u.getSongList()){
        if(s.getSeconds() < 10){
          list.add(String.format("%-30s %-30s %-30s  %-30s", s.getTitle() , s.getArtist(), s.getMinutes() + ":0" + s.getSeconds(), u.userName));
        }
        else{
          list.add(String.format("%-30s %-30s %-30s  %-30s", s.getTitle() , s.getArtist(), s.getMinutes() + ":" + s.getSeconds(), u.userName));
        }
      }

    }

    return list;
  }
  public List<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){//return list with contents of part 3
    List<String> list = new ArrayList<String>();
    list.add(String.format("%-30s %-30s %-30s %-30s", "TITLE" , "ARTIST", "Time" , "OWNER"));

    for (User u : m.onlineUsers()){
      for (Song s: u.getSongList()){
        if (s.getArtist().equals(artist)){
          list.add(String.format("%-30s %-30s %-30s  %-30s", s.getTitle() , s.getArtist(), s.getMinutes() + ":" + s.getSeconds(), u.userName));
        }
      }

    }

    return list;
  }
  public Song songWithTitle(String title) {
    for (Song s : songList) {
      if (s.getTitle().equals(title)) {
        return s;
      }
    }
    return null;
  }
  public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
    if(this.songList != null && this.isOnline()){
      Song s = m.getSong(title, ownerName);
      if (s != null){
        songList.add(s);
      }
    }
  }

  public String toString()  {
    String s = "" + userName + ": " + songList.size() +" songs (";
    if (!online) s += "not ";
    return s + "online)";
  }
}
