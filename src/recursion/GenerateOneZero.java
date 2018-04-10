package recursion;

import java.util.Arrays;

/**
 * Created by sergei.kostin on 4/9/18.
 */
public class GenerateOneZero {

    public void generate(String s){
        generate(s.toCharArray(), 0);
    }

    private void generate(char[] arr, int index){
        if(index == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        if(arr[index] != '?'){
            generate(arr, index+1);
        }else{
            arr[index] = '0';
            generate(arr, index +1);
            arr[index] = '1';
            generate(arr, index +1);
            arr[index] = '?';
        }
    }

    public static void main(String[] args) {
        GenerateOneZero goz = new GenerateOneZero();
        goz.generate("1?0?1");
    }


}
