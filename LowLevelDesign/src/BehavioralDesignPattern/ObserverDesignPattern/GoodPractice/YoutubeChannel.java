package BehavioralDesignPattern.ObserverDesignPattern.GoodPractice;

public interface YoutubeChannel {

    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();

}
