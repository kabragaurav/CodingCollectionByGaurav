package LowLevelSystemDesign.DesignPrinciples.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Channel {
    List<Subscriber> subscribers = new ArrayList<>();

    public boolean addSubscriber(Subscriber subscriber) {
        return subscribers.add(subscriber);
    }

    public boolean removeSubscriber(Subscriber subscriber) {
        return subscribers.remove(subscriber);
    }

    public void publishVideo(String title) {
        for (Subscriber subscriber : subscribers) {
            subscriber.showNotification(title);
        }
    }

}
