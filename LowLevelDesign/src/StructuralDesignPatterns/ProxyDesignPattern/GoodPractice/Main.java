package StructuralDesignPatterns.ProxyDesignPattern.GoodPractice;

public class Main {
    public static void main(String[] args) {
        RealVideoService realVideoService = new RealVideoService();
        ProxyVideoService proxyService = new ProxyVideoService(realVideoService);

        // Free user trying to watch a video
        proxyService.playVideo("free", "FreeVideo 1");
        // Premium user trying to watch a video
        proxyService.playVideo("premium", "Premium Video 1");
        // Unauthorized user
        proxyService.playVideo("guest", "Video 1");
        // Too many requests
        for (int i = 0; i < 6; i++) {
            proxyService.playVideo("free", "Free Video 2");
        }
    }
}
