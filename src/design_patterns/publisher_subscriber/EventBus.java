package design_patterns.publisher_subscriber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class EventBus {

    private Queue<Message> messageQueue = new LinkedList<>();
    private List<Subscriber> subscribers = new ArrayList<>();

    public void processMessage(Message message){
        for(Subscriber s : subscribers){
            if(s.getTopics().contains(message.getTopic())){
                s.displayMessage(message.getData());
            }
        }
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

}
