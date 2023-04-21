import java.util.*;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList; //album should contain list of songs

    //initialize the songList
    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String title){
        //iterate over the list and match each song title with title
        for(Song song: songList){
            if((song.title).equals(title)){
                return true;
            }
        }
        return false;
    }
    public String addSongToAlbum(String title, double duration){
        //if song already exists, do not add
        //otherwise create a new song and add to the album
        if(findSongInAlbum(title) == true){
            return "Song is already present";
        }else{
            //create a song and add it
            //create object of song
            Song newSong = new Song(title, duration);
            songList.add(newSong);
            return "New song has been added successfully";
        }
    }

    public String addSongToPlayList(int trackNo, LinkedList<Song> playList){
        //TrackNo is a number in the songlist
        //Track Number start frm 1,2,3,4,5....
        //indices: 0,1,2,3,4....
        int index = trackNo -1;

        //checking for validity of index
        if(index >= 0 && index<this.songList.size()){
            Song song = this.songList.get(index);
            playList.add(song);

            return "Song added to the playlist";
        }
        return "Invalid track No";
    }

    public String addSongToPlayList(String title, LinkedList<Song> playList){
        //I need to find out that Song with the title
        //and put it in the playlist

        //iterate

        for(Song song: songList){
            if(title.equals(song.title)){
                playList.add(song);
                return "Song added to playlist";
            }
        }
        return "Song does not exist";
    }

}