package object_oriented_design.call_center;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public interface CallResponderChain {

    void setNextResponderChain(CallResponderChain chain);
    void answerCall();

}
