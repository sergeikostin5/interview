package object_oriented_design.call_center;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public abstract class Employee implements CallResponderChain {

    private EmployeeRank rank;
    private Call currentCall;

    public enum EmployeeRank{
        RESPONDENT, MANAGER, DIRECTOR;
    }

    public void receiveCall(Call call){
        currentCall = call;
    }

    public void callCompleted(){
        currentCall = null;
    }

    public boolean isFree(){
        return currentCall == null;
    }

    public EmployeeRank getRank(){
        return rank;
    }

    public void setRank(EmployeeRank rank) {
        this.rank = rank;
    }
}
