import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name,String artist,ArrayList<Song> songs){
        this.name=name;
        this.artist=artist;
        this.songs= new ArrayList<Song>();

    }
    public Album(String string, String string2){

    }
    public Song findSong(String title){
        for(Song checkedSong: songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;    
        }
        return null;
    }
    public boolean addSong(String title,double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
            System.out.println(title + " good job it is added to the list");
            return true;
        }
        else{
            System.out.println("song with name: "+ title + "already exists in the list");
            return false;
        }
    }
    /* based on the track number */
    public boolean addToPlayList(int trackNumber,LinkedList<Song> PlayList){
        int index=trackNumber - 1;
        if(index > 0 && index <=this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have track with this track number"+ trackNumber);
        return false;
    } 
    /*based on the the song title  */
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){

        for(Song checkedSong:this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title + " there is no such song in the album ");
        return false;
        
    }
}

