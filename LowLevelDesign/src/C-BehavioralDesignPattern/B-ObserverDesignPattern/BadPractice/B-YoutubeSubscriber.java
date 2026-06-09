package BehavioralDesignPattern.ObserverDesignPattern.BadPractice;

public class YoutubeSubscriber {

    private String name;
    public YoutubeSubscriber(String name){
        this.name = name;
    }

    public void subscribe(YoutubeChannel channel) {
        channel.addSubscriber(name);
    }
    public void watchVideo(YoutubeChannel channel) {
        System.out.println(name + " is watching the video: " + channel.video);
    }
}

