package BehavioralDesignPattern.ObserverDesignPattern.BadPractice;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel {

    private List<String> subscribers = new ArrayList<>();
    public String video;

    public void addSubscriber(String subscriber){
       subscribers.add(subscriber);
    }

    public void uploadNewVideo(String video){
        this.video = video;
        notifySubscribers();
    }

    public void notifySubscribers(){

        for(String subscriber: subscribers){
            System.out.println("Notifying " + subscriber + " about new video " + video);
        }
    }
}


