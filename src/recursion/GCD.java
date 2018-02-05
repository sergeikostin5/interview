package recursion;

/**
 * Created by sergei.kostin on 12/20/17.
 */
public class GCD {

    public int gcdIterative(int num1, int num2){

        while(num1%num2 != 0){
            int temp = num2;
            num2 = num1%num2;
            num1 = temp;
        }

        return num2;
    }

    public int gcdRecursive(int num1, int num2){
        if(num1%num2 == 0) return num2;

        return gcdRecursive(num2, num1%num2);
    }

    public static void main(String[] args) {
        GCD g = new GCD();
        System.out.println(g.gcdRecursive(4,10));
    }


}
