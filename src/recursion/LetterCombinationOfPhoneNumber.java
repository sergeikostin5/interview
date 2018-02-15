package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 2/9/18.
 */
public class LetterCombinationOfPhoneNumber {

    public List<String> letterCombinations(String digits) {

        char[] arr = digits.toCharArray();
        String[] map = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        char[] subResult = new char[digits.length()];

        List<String> result = new ArrayList<>();

        letterCombinations(arr, result, subResult, 0, map);
        return result;
    }

    private void letterCombinations(char[] input, List<String> result, char[] subResult, int level, String[] map ){
        if(level == input.length){
            String temp = new String(subResult);
            result.add(temp);
            return;
        }
        int pointer = Character.getNumericValue(input[level]);
        for(int i = 0; i < map[pointer].length(); i++){
            subResult[level] = map[pointer].charAt(i);
            letterCombinations(input, result, subResult, level+1, map);
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber lcn = new LetterCombinationOfPhoneNumber();
        List<String> res = lcn.letterCombinations("23");
        for(String elem : res){
            System.out.println(elem);
        }
    }

}
