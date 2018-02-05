package recursion;

/**
 * Created by sergei.kostin on 1/4/18.
 */
public class Power {

    public double pow( double a, int b){
        if(b == 0){
            return 1;
        }
        else if (b <0 ) return 1/a*pow(a, b+1);
        else return a*pow(a, b-1);
    }


    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.pow(-2,-3));
    }

}
