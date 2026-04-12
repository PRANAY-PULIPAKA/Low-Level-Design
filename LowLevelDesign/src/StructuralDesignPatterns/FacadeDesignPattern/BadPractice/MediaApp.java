package StructuralDesignPatterns.FacadeDesignPattern.BadPractice;

import java.util.Scanner;

public class MediaApp {
    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        System.out.println("Choose an action: PlayMusic, platVideo, viewImage");
        String action = scanner.nextLine();

        if(action.equalsIgnoreCase("playMusic")){
            MusicPlayer musicPlayer =  new MusicPlayer();
            musicPlayer.initializeAudioDrivers();
            musicPlayer.decodeAudio();
            musicPlayer.startPlayback();
        } else if (action.equalsIgnoreCase("playVideo")) {
            VideoPlayer videoPlayer = new VideoPlayer();
            videoPlayer.setupRenderingEngine();
            videoPlayer.loadVideoFile();
            videoPlayer.playVideo();
        } else if (action.equalsIgnoreCase("viewImage")) {
            ImageViewer imageViewer = new ImageViewer();
            imageViewer.loadImageFile();
            imageViewer.applyScaling();
            imageViewer.displayImage();
        } else {
            System.out.println("Invalid action!");
        }
        scanner.close();
    }

}
class MusicPlayer{
    void initializeAudioDrivers(){
        System.out.println("Initializing drivers");
    }

    void decodeAudio(){
        System.out.println("Decoding the audio");
    }

    void startPlayback(){
        System.out.println("Starting playBack");
    }
}

class VideoPlayer{
    void setupRenderingEngine(){
        System.out.println("setting up rendering engine");
    }

    void loadVideoFile(){
        System.out.println("Loading video files");
    }

    void playVideo(){
        System.out.println("playing video");
    }
}

class  ImageViewer{
    void loadImageFile(){
        System.out.println("Loading image file");
    }

    void applyScaling(){
        System.out.println("setting image size");
    }

    void displayImage(){
        System.out.println("Displaying image");
    }
}
