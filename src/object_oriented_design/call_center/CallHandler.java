package object_oriented_design.call_center;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class CallHandler {

    private static CallHandler instance;
    private int numResponders = 10;
    private int numManagers = 10;
    private int numDirectors = 10;


    private CallHandler(){

    }

    public static CallHandler getInstance(){
        if(instance == null) instance = new CallHandler();
        return instance;
    }


}
