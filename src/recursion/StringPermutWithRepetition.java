package recursion;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sergei.kostin on 10/25/17.
 *
 * Problem def:
 * Print out all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 */

public class StringPermutWithRepetition {

    public void permute(char[] arr){

        Map<Character, Integer> countMap = new TreeMap<>();
        for(Character c : arr){
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        System.out.println(countMap);
        char[] charArr = new char[countMap.size()];
        int[] intArr = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            charArr[index] = entry.getKey();
            intArr[index] = entry.getValue();
            index++;
        }

        char[] result = new char[arr.length];
        permUtil(charArr, intArr, result, 0);

    }

    private void permUtil(char[] charArr, int[] countArr, char[] result, int level){
        if(level == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i = 0; i < charArr.length; i++){
            if(countArr[i] == 0){
                continue;
            }
            result[level] = charArr[i];
            countArr[i]--;
            permUtil(charArr, countArr, result, level+1);
            countArr[i]++;

        }
    }

    public static void main(String[] args) {
        StringPermutWithRepetition perm = new StringPermutWithRepetition();
        perm.permute(new char[]{'A','A','B','C'});
    }

}
