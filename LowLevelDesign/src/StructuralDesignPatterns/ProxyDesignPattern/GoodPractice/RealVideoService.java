package StructuralDesignPatterns.ProxyDesignPattern.GoodPractice;

import StructuralDesignPatterns.ProxyDesignPattern.BadPractice.VideoService;

public class RealVideoService implements VideoServiceInterface {
    @Override
    public void playVideo(String userType, String videoName) {
        System.out.println("Streaming video: " + videoName);
    }
}
