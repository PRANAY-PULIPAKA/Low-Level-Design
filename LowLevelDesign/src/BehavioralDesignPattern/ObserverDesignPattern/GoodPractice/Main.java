package BehavioralDesignPattern.ObserverDesignPattern.GoodPractice;

public class Main {

    public static void main(String[] args) {
        // Create a YouTube channel
        YouTubeChannelImpl channel = new YouTubeChannelImpl();
        // Create subscribers
        YoutubeSubscriber alice = new YoutubeSubscriber("Alice");
        YoutubeSubscriber bob = new YoutubeSubscriber("Bob");
        // Subscribe to the channel
        channel.addSubscriber(alice);
        channel.addSubscriber(bob);
        // Upload a new video and notify subscribers
        channel.uploadNewVideo("Java Design Patterns Tutorial");
        // Output:
        // Alice is watching the video: Java Design Patterns Tutorial
        // Bob is watching the video: Java Design Patterns Tutorial
        // You can also remove a subscriber and upload another video
        channel.removeSubscriber(bob);
        channel.uploadNewVideo("Observer Pattern in Action");
        // Output:
        // Alice is watching the video: Observer Pattern in Action
    }
}
