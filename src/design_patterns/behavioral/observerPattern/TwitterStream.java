package design_patterns.behavioral.observerPattern;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by sergei.kostin on 3/24/18.
 */
public class TwitterStream extends Observable {

    private Deque<String> messageHistory = new ArrayDeque<>();

    @Override
    void setState(String state) {
        messageHistory.add(state);
        notifyObservers();
    }

    @Override
    String getState() {
        return messageHistory.getLast();
    }
}
