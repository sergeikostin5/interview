package design_patterns.publisher_subscriber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class Subscriber {

    private List<String> topics = new ArrayList<>();
    private String name;

    public void subscribe(String topic){
        topics.add(topic);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayMessage(String message){
        System.out.println(name + "received message " + message);
    }

    public List<String> getTopics() {
        return topics;
    }

}
