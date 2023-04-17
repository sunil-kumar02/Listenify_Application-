package Listenify;

import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
     public static void main(String[] args) {
        System.out.println("Hello world!");

        Album album = new Album("Old Song ","Ariji singh");

        album.addSongToAlbum("pathan",4.5);
        album.addSongToAlbum("channa mereya",4.2);
        album.addSongToAlbum("Naina",2.3);

         albums.add(album);

         album = new Album("Album2","Sonu nigam");

         album.addSongToAlbum("kasoor",3.5);
         album.addSongToAlbum("tum mile",5.4);
         album.addSongToAlbum("Barishe",2.1);

         albums.add(album);
        LinkedList<Song> PlayList_1 = new LinkedList<>();

        albums.get(0).addSongToPlayList("pathan",PlayList_1);
        albums.get(0).addSongToPlayList("Naina",PlayList_1);
        albums.get(1).addSongToPlayList("kasoor",PlayList_1);
        albums.get(1).addSongToPlayList("Barishe",PlayList_1);

        //printing the playlist that has been added
         play(PlayList_1);


     }

     public static void play(LinkedList<Song> playList){

         ListIterator<Song>listIterator = playList.listIterator();
         if(playList.size() == 0){
             return;
         }
         Scanner sc = new Scanner(System.in);
         printMenu();

         System.out.println("Now Playing "+listIterator.next());
         boolean forward = true;
         boolean quit = false;

         while(quit == false){
             int choice = sc.nextInt();

             switch(choice) {
                 case 0:

                 case 1:
                     if (forward == false) {
                         listIterator.next();
                         forward = true;
                     }
                     if (listIterator.hasNext()) {
                         System.out.println(listIterator.next().toString());
                     } else {
                         System.out.println("you are at the last song");
                     }
                     //to play the next Song
                     break;
                 case 2:
                     if (forward == true) {
                         listIterator.previous();
                         forward = false;
                     }
                     if (listIterator.hasPrevious()) {
                         System.out.println(listIterator.previous().toString());
                     } else {
                         System.out.println("you are already at the first song ");
                     }
                     //to play the next song
                     break;
                 case 3:
                     if (forward == true) {//i am on rhs : print the previous song
                         System.out.println(listIterator.previous().toString());
                         forward = false;
                     } else {
                         System.out.println(listIterator.next().toString());
                         forward = true;
                     }
                     break;
                 //replay the current songs

                 case 4:
                     printAllSongs(playList);
                     break;

                 case 5:
                     printMenu();
                     break;
                 case 6:
                     //delate a song
                     if (playList.size() > 0) {
                         System.out.println(listIterator.previous().toString() + " has been removed from the playlist.");
                         listIterator.remove();
                         if (playList.size() > 0 && listIterator.hasPrevious()) {
                             System.out.println("Now playing " + listIterator.next().toString());
                         } else if (playList.size() > 0 && listIterator.hasNext()) {
                             System.out.println("Now playing " + listIterator.previous().toString());
                         }
                     } else {
                         System.out.println("The playlist is already empty.");
                     }
                     break;
             }
         }

     }
     private static void printAllSongs(LinkedList<Song>songs){
         ListIterator<Song> listIterator = songs.listIterator();
         //for each loop
         while(listIterator.hasNext()){
             System.out.println(listIterator.next().toString());
         }
     }

     private static void printMenu(){
         System.out.println("Available options\n press");
         System.out.println("0 to quit\n"+
                 "1 - to play next SOng\n"+
                 "2 - to play prevoius song\n"+
                 "3 - to replay the current song\n"+
                 "4 - list of all song\n"+
                 "5 - print all available options\n"+
                 "6 - declare current songs");
     }

}


