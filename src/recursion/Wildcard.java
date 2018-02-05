package recursion;

import java.util.Arrays;

/**
 * Created by sergei.kostin on 11/8/17.
 */
public class Wildcard {

    private static char[] symbs = {'0','1'};

    public static void main(String[] args) {
        Wildcard wildcard = new Wildcard();
        char[] arr = new char[]{'1','?','0','?', '?'};
        wildcard.wildcard(arr, 0);
    }

//    public void wildcard(char[] arr, int i){
//        if( i == arr.length ){
//            System.out.println(Arrays.toString(arr));
//            return;
//        }
//        if(arr[i] != '?'){
//            wildcard(arr, i+1);
//        } else {
//            arr[i] = '0';
//            wildcard(arr, i+1);
//            arr[i] = '1';
//            wildcard(arr, i+1);
//            arr[i] = '?';
//        }
//
//    }


    public void wildcard(char[] arr, int i){
        if(i == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        while(i<arr.length && arr[i] != '?'){
            i++;
        }
        if(i == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(char el : symbs){
            arr[i]=el;
            wildcard(arr, i+1);
        }
        arr[i] = '?';
    }
}
