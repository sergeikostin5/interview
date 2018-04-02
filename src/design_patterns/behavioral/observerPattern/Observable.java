package design_patterns.behavioral.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 3/24/18.
 */
public abstract class Observable {

    private List<Observer> observers = new ArrayList<>();

    abstract void setState(String state);
    abstract String getState();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update();
        }
    }


}
