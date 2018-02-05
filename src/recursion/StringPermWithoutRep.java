package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergei.kostin on 11/5/17.
 */
public class StringPermWithoutRep {

    char[] vowels = {'a', 'e', 'i', 'o','y'};

    public void perm(char[] input){
        permUtil(input, 0);
    }

    private void permUtil(char[] input, int level){

        if(level == input.length - 1) System.out.println(Arrays.toString(input));

        for(int i = level; i < input.length; i++){
            swap(input, i, level);
            permUtil(input, level+1);
            swap(input, level, i);
        }

    }

    public void printVowelConsonant(char[] arr){
        printVowelConsonant(arr, 0);
    }

    private void printVowelConsonant(char[] arr, int level){
        if(level == arr.length) System.out.println(Arrays.toString(arr));

        for(int i = level; i < arr.length; i++){
            swap(arr, i, level);
            if( level > 1 && ((isVowel(arr[level]) && isVowel(arr[level-1])) || (!isVowel(arr[level]) && !isVowel(arr[level-1])))){
                swap(arr, level, i);
                continue;
            }
            printVowelConsonant(arr, level+1);
            swap(arr, level, i);
        }
    }

    public boolean printIfDict(char[] arr, int level){
        if(level == arr.length) {
            if(isInDictionary(arr)){
                System.out.println(Arrays.toString(arr));
                return true;
            }
            return false;
        }
        for(int i = level; i< arr.length; i++){
            swap(arr, i , level);
            if(printIfDict(arr, level+1)){
                swap(arr, level, i);
                return true;
            }
            swap(arr, level, i);
        }
        return false;
    }

    private void swap(char[] input, int i, int level) {
        char temp = input[i];
        input[i] = input[level];
        input[level] = temp;
    }

    private boolean isVowel(char c){
        for(char elem : vowels){
            if(elem == c) return true;
        }
        return false;
    }

    private boolean isInDictionary(char[] arr){
        String temp = new String(arr);
        String str1 = "beca";
        String str2 = "cbea";
        if(temp.equals(str1) || temp.equals(str2)) return true;
        return false;
    }

    public static void main(String[] args) {
        StringPermWithoutRep stringPerm = new StringPermWithoutRep();
        String input = "abce";
        stringPerm.printIfDict(input.toCharArray(), 0);
    }

}
