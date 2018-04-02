package strings;

import java.util.Arrays;

/**
 * Created by sergei.kostin on 4/1/18.
 */
public class StringCompression_443 {

    public int compress(char[] chars) {
        int result = 0;
        int index = 0;
        for(int i = 0; i < chars.length; i++){
            int curLength = getLength(chars, i);
            if(curLength == 1) {
                chars[index] = chars[i];
                result++;
                index++;
            } else {
              char[] size = Integer.toString(curLength).toCharArray();
              chars[index] = chars[i];
              for(char c : size) {
                  chars[index + 1] = c;
                  result += 1;
                  index += 1;

              }
                result += 1;
                index += 1;
                i += curLength - 1;
            }
        }

        return result;
    }

    private int getLength(char[] arr, int i){
        int counter = 1;
        for(;i < arr.length - 1; i++ ){
            if(arr[i] == arr[i+1]) counter++;
            else return counter;
        }
        return counter;
    }

    public static void main(String[] args) {
        char[] arr = {'a','a','a','b','b','b','b','b','b','b','b','b','b','b','b','c','c','c','c','c',};
        StringCompression_443 sc = new StringCompression_443();
        System.out.println(sc.compress(arr));
        System.out.println(Arrays.toString(arr));
    }


}
