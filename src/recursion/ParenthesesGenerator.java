package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 11/8/17.
 */
public class ParenthesesGenerator {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(1, 0, result, n, "(");
        return result;
    }

    private void generateParenthesis(int open, int close, List<String> result, int n, String temp) {
        if(open == n && close == n){
            result.add(temp);
            return;
        }
        if(open > n || close > open) return;
        generateParenthesis(open + 1, close, result, n, temp+"(");
        generateParenthesis(open, close+1, result, n, temp+")");
    }

    public static void main(String[] args) {
        ParenthesesGenerator generator = new ParenthesesGenerator();
        List<String> result = generator.generateParenthesis(3);
        for(String elem :result){
            System.out.println(elem);
        }
    }
}
