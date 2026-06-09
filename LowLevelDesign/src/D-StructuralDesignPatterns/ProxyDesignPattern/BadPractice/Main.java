package StructuralDesignPatterns.ProxyDesignPattern.BadPractice;

public class Main {
    public static void main(String[] args) {

        VideoService videoService = new VideoService();
        // Free user trying to watch a video
        videoService.playVideo("free", "Free Video 1");
        // Premium user trying to watch a video
        videoService.playVideo("premium", "Premium Video 1");
        // Unauthorized user
        videoService.playVideo("guest", "Video 1");
    }
}
