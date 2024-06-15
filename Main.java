import java.util.*;

public class Main
{
    private static ArrayList<Album> albums = new ArrayList<>();
    public static  void main(String args[])
    {


        Album album = new Album("Album1","AC/DC");
        album.addSong("TNT",4.5);
        album.addSong("Highway to hell ",3.5);
        album.addSong("ThunderStruck",5.0);
        albums.add(album);

        album = new Album("Album2","Eminem");

        album.addSong("RapGod",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose Yourself",4.5);
        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();

        //accessing the album's playlist
        albums.get(0).addToPlaylist("TNT",playlist_1);
        albums.get(0).addToPlaylist("Highway to hell ",playlist_1);
        albums.get(1).addToPlaylist("RapGod",playlist_1);
        albums.get(1).addToPlaylist("Lose Yourself",playlist_1);

        play(playlist_1);
    }
    private static void play(LinkedList<Song> playlist)
    {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.size() == 0){
            System.out.println("This playlist is empty");
        }
        else{
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){ //if next song exists then list iterator is being shifted
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("No Song Available, reached to end of the list");
                        forward = false;
                    }
                    break;
                case 2://to play previous song
                    if(forward){
                        if(listIterator.hasPrevious()){ //checking if list has previous song
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now Playing "+listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;

                case 3: //for current song
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing "+listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start of the palylist");
                        }
                    }else {
                            if(listIterator.hasNext()){
                                System.out.println("Now Playing "+listIterator.previous().toString());
                                forward = true;
                            }else {
                                System.out.println("We have reached to the end of the playlist");
                            }
                        }
                    break;

                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6://if deleted the song then either next or previous song will play
                    if(playlist.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("Now Playing "+listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private  static void printMenu(){
        System.out.println("Available options \n Press");
        System.out.println("0 - to quit \n " +
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay current song\n"+
                "4 - list of all songs\n"+
                "5 - print all the available options\n"+
                "6 - delete the current song from our album");
        System.out.println();
    }

    //printitng the list with different method
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("______________________");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("______________________");
    }
}
