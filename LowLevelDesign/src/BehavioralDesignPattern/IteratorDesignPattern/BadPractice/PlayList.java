package BehavioralDesignPattern.IteratorDesignPattern.BadPractice;

import java.util.ArrayList;

public class PlayList {
    private ArrayList<String> songs;

    public PlayList(){
        songs = new ArrayList<>();
    }

    public void addSong(String song){
        songs.add(song);
    }
    public void playPlayList(boolean shuffle){
        if(shuffle){
            System.out.println("Shiff;ing Playlist");
        } else {
            for(int i = 0; i < songs.size(); i++) {
                System.out.println("Playing songs: " + songs.get(i));
            }
        }
    }
}
