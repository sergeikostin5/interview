package design_patterns.publisher_subscriber;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class Publisher {

    private EventBus mBus;

    public Publisher(EventBus mBus) {
        this.mBus = mBus;
    }

    public void sendMessage(Message message){
        mBus.processMessage(message);
    }


    public static void main(String[] args) {

    }
}
