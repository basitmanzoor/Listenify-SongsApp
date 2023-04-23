
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("hello world");
        Album album = new Album("Aabad", "Yawar Abdal");

        album.addSongToAlbum("Insha Allah", 3.5);
        album.addSongToAlbum("Kalakar", 4.5);
        album.addSongToAlbum("Iman", 2.4);

        albums.add(album);

        album = new Album("Sufayed", "Alif");

        album.addSongToAlbum("Ali", 4.2);
        album.addSongToAlbum("Malaal Kya Huwa", 3.4);
        album.addSongToAlbum("Peer Ti Peeri", 5.2);

        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();

        albums.get(0).addSongToPlayList("Iman",playlist_1);
        albums.get(0).addSongToPlayList("Kalakar",playlist_1);
        albums.get(1).addSongToPlayList("Ali",playlist_1);
        albums.get(1).addSongToPlayList("Peer Ti Peeri",playlist_1);

        //print the playlist
        play(playlist_1);
    }

    public static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            return;
        }
        Scanner sc = new Scanner(System.in);
        printMenu();

        System.out.println("Now playing "+ listIterator.next());
        boolean forward = true;
        boolean quit = false;

        while(quit ==false){
            int choice = sc.nextInt();

            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    if(forward == false){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }else{
                        System.out.println("you are at the last");
                    }
                    //to play the next song;
                    break;
                case 2:
                    //to play the previous song
                    if(forward == true){
                        //already towards the right of last printed value
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }else{
                        System.out.println("You are already at the first song");
                    }
                    break;
                case 3:
                    //replay the current song
                    if(forward == true){
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }else{
                        //forward is false
                        System.out.println(listIterator.next().toString());
                        forward =true;
                    }
                    break;
                case 4:
                    //print all list of songs
                    printAllSongs(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    //delete a song
                    break;
            }
        }

    }
    public static void printAllSongs(LinkedList<Song> songs){
        ListIterator<Song> listIterator = songs.listIterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }
    public static void printMenu(){
        //different options that we have
        System.out.println("Available options \n press");
        System.out.println("0 - to quit \n"+
                "1 - to play next song \n"+
                "2 - to play previous song \n"+
                "3 - to replay the current song \n"+
                "4 - list of all songs \n"+
                "5 - print all available songs \n"+
                "6 - delete current song \n"
        );
    }

}
