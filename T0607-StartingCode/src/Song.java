public class Song implements Comparable<Song> {
  private String title;
  private String artist;
  private int duration;
  private User owner = null;
  public Song()  {
    this("", "", 0, 0);
  }
  
  public Song(String t, String a, int m, int s)  {
    title = t;
    artist = a;
    duration = m * 60 + s;
  }
  
  public String getTitle() { 
    return title; 
  } 
  
  public String getArtist() { 
    return artist; 
  }
  
  public int getDuration() { 
    return duration; 
  }

  public int getMinutes() {
    return duration / 60;
  }

  public int getSeconds() {
    return duration % 60;
  }

  public void setOwner(User u){
    owner = u;
  }
  public User getOwner() {
    return owner;
  }
  public int compareTo(Song s){//for treeset
    return title.compareTo(s.title);
  }
  
  public String toString()  {
    return("\"" + title + "\" by " + artist + " " + (duration / 60) + ":" + (duration%60));
  }
}
