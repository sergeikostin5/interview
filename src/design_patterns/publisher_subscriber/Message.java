package design_patterns.publisher_subscriber;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class Message {

    private String data;
    private String topic;

    public Message(String data, String topic) {
        this.data = data;
        this.topic = topic;
    }

    public String getData() {
        return data;
    }

    public String getTopic() {
        return topic;
    }
}
