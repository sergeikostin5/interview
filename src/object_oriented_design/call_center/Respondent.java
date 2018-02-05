package object_oriented_design.call_center;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class Respondent extends Employee {

    private CallResponderChain nextChain;


    public Respondent(){
        setRank(EmployeeRank.RESPONDENT);
    }

    @Override
    public void setNextResponderChain( CallResponderChain chain) {
        nextChain = chain;
    }

    @Override
    public void answerCall() {
        //try to answer call
        // if not able
        nextChain.answerCall();
    }


}
