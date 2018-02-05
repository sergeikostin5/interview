package object_oriented_design.call_center;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class Manager extends Employee {

    public Manager(){
        setRank(EmployeeRank.MANAGER);
    }

    @Override
    public void setNextResponderChain(CallResponderChain chain) {

    }

    @Override
    public void answerCall() {

    }
}
