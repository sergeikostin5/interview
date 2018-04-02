package design_patterns.behavioral.observerPattern;

/**
 * Created by sergei.kostin on 3/24/18.
 */
public abstract class Observer {

    protected Observable subject;
    abstract void update();

}
