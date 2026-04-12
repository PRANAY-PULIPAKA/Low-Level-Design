package StructuralDesignPatterns.FacadeDesignPattern.GoodPractice;

public class VideoPlayer {

    public void setupRenderingEngine(){
        System.out.println("Rendering engine setup");
    }

    public void loadVideoFile(){
        System.out.println("Video file loaded");
    }

    public void playVideo(){
        System.out.println("video playback started");
    }
}


