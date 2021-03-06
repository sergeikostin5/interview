package dynamic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sergei.kostin on 12/25/17.
 */
public class Fibonacci {

    public int fibonacci(int n){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, 0);
        map.put(1,1);
        return fibonacci(n, map);
    }

    public int fibonacciDp(int n){
        int[] cache = new int[2];
        cache[1] = 1;

        for(int i = 2; i <= n; i++){
            int temp = cache[1];
            cache[1] = cache[1] + cache[0];
            cache[0] = temp;
        }

        return cache[1];
    }

    private int fibonacci(int n, Map<Integer, Integer> map){
        if(map.containsKey(n)) {
            int val = map.get(n);
            if(map.containsKey(n+1)) map.remove(n);
            return val;
        }
        else {
            int n1 = fibonacci(n - 1, map);
            int n2 = fibonacci(n - 2, map);
            map.put(n, n1+n2);
            System.out.println("map " + map.size());
            return n1+n2;
        }
    }



    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fibonacciDp(9));
    }

}
