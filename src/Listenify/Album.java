package Listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    public String albumName;
    public String artistName;

    public List<Song> songList;

    //initialise the songList
    public Album(String albumName, String artistName) {
        this.albumName = albumName;

        this.artistName = artistName;

        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String title) {

        //iterate over the arraylist if found and match the title with the given title
        for (Song song : songList) {
            if ((song.title).equals(title)) {
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration) {
        //check if the song is already present we will not add
        //otherwise we will add the song in songlist

        if (findSongInAlbum(title) == true) {
            return "song is alreasy present";
        } else {
            //i need to create an object and add it to songList
            Song newSong = new Song(title, duration);
            songList.add(newSong);
            return "new Song has been added successfully";
        }
    }

    public String addSongToPlayList(int trackNo, LinkedList<Song> playList) {
        // trackno is the no in the songList
        //trackno = 1,2,3,4......
        //indices = 0,1,2,3,4......
        int index = trackNo - 1;

        //put

        //checking for the validity of the index
        if (index >= 0 && index < this.songList.size()) {
            //add to the playlist
            Song song = this.songList.get(index);
            playList.add(song);

            return "song added to the playlist";

        }
        return "Invalid Track No";
    }

    public String addSongToPlayList(String title, LinkedList<Song> playList) {
        //i need to find out that song
        //put it to the playlist
        //iterate over the songlist
        for (Song song : songList) {
            if ((song.title).equals(title)) {
                playList.add(song);

                return "Succesfully song is added in the playlist";
            }
        }
        return "song does not exist";


    }
}
