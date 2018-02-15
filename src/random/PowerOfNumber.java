package random;

import java.util.HashMap;

/**
 * Created by sergei.kostin on 2/6/18.
 */
public class PowerOfNumber {

    public double myPow(double x, int n){
        HashMap<Integer, Double> cache = new HashMap<>();
        return myPow(x,n,cache);
    }

    private double myPow(double x, int n, HashMap<Integer, Double> cache) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        if(cache.containsKey(n)) return cache.get(n);
        double n1;
        double n2;
        if(n > 0) {
            if (n % 2 == 0){
                n1 = myPow(x, n / 2, cache);
                n2 = myPow(x, n / 2, cache);
            }
            else {
                n1 = myPow(x, n - 1, cache);
                n2 = myPow(x, 1, cache);
            }
        } else {
            if (n % 2 == 0){
                n1 = myPow(x, n / 2, cache);
                n2 = myPow(x, n / 2, cache);
            }
            else {
                n1 = myPow(x, n + 1, cache);
                n2 = myPow(x, -1, cache);
            }
        }
        cache.put(n, n1*n2);
        return cache.get(n);
    }

    public static void main(String[] args) {
        PowerOfNumber pw = new PowerOfNumber();
        System.out.println(pw.myPow(2,5));
    }

}
