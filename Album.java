import java.util.ArrayList;
import java.util.LinkedList;

public class Album
{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album(){ //Empty Constructor
    }

    public Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;

    }

    public boolean addSong(String title , double duration){
        if(findSong(title)==null)
        {
            songs.add(new Song(title,duration));
           // System.out.println(title+"successfully added to the list");
            return true;
        }
        else{
            //System.out.println("Son with name "+title+"alreaady exists in the list");
            return false;
        }
    }

    public boolean addToPlaylist(int trackNumber , LinkedList<Song> Playlist){ //checking if track number is valid or not
      int index = trackNumber -1 ;
      if(index > 0 && index <= this.songs.size()){
          Playlist.add(this.songs.get(index));
          return true;
      }
      //  System.out.println("This album does not have song with tracknumber "+trackNumber);
      return false;
    }

    public boolean addToPlaylist(String title , LinkedList<Song> Playlist){ //checking if the title exists or not
        for(Song checkedSong  : this.songs){
            if(checkedSong.getTitle().equals(title))
            {
                Playlist.add(checkedSong);
                return true;
            }
        }
      //  System.out.println(title+"There is no such song in the album");
        return false;
    }
}
