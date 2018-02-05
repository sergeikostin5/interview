package object_oriented_design.call_center;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class Director extends Employee {

    public Director(){
        setRank(EmployeeRank.DIRECTOR);
    }

    @Override
    public void setNextResponderChain(CallResponderChain chain) {

    }

    @Override
    public void answerCall() {

    }
}
