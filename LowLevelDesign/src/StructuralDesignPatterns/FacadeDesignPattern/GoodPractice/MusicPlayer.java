package StructuralDesignPatterns.FacadeDesignPattern.GoodPractice;

//check this link for actual implementation
//https://chatgpt.com/c/69647538-b2f4-8323-bd90-274be2db0e1e
public class MusicPlayer {

    public void initializeAudioDrivers(){
        System.out.println("Initialized Audio drivers");
    }

    public void decodeAudio(){
        System.out.println("Audio decoded");
    }

    public void startPlayBack(){
        System.out.println("Music playback started");
    }

}
