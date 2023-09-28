import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String args[]) {

        Album album1 = new Album("album1", "ac/dc", null);

        album1.addSong("TNT", 4.4);
        album1.addSong("highway to hell", 3.4);
        album1.addSong("hell", 5.4);
        album1.addSong("come back", 2.4);
        albums.add(album1);

        Album album2 = new Album("Album2", "aster", null);

        album2.addSong("price", 1.4);
        album2.addSong("highway to home", 2.4);
        album2.addSong("hell", 5.1);
        album2.addSong("go back", 4.1);

        albums.add(album2);
        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT", playList_1);
        albums.get(0).addToPlayList("highway to hell", playList_1);
        albums.get(1).addToPlayList("hell", playList_1);
        albums.get(1).addToPlayList("price", playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This PlayList does not have any song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {

                case 0:
                    System.out.println("PlayList complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No song present, reached the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are on the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    } else {
                        System.out.println("No songs in the playlist");
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options\nPress:");
        System.out.println("0 - Stop\n" +
                "1 - Play next song\n" +
                "2 - Play previous song\n" +
                "3 - Replay the current song\n" +
                "4 - List all songs\n" +
                "5 - Print available options\n" +
                "6 - Delete current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------");
    }
}
