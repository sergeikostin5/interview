package recursion;

import java.util.*;

/**
 * Created by sergei.kostin on 12/28/17.
 */
public class ExpressionEvaluator {

    public List<String> evaluateExpression(String str, int target){
        char[] nums = str.toCharArray();
        char[] symbs = {' ', '+', '*'};
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        evaluateExpression(nums, symbs, 0, builder, result, target);
        return result;
    }

    private void evaluateExpression(char[] nums, char[] symbs, int numIndex, StringBuilder builder, List<String> result, int target){

        if(builder.length() >= nums.length*2-1){
//            if(isValid(builder.toString(), target )) {
                result.add(builder.toString());
//            }
            return;
        }
        for(int i = 0; i < symbs.length; i++){
            builder.append(nums[numIndex]);
            if(numIndex != nums.length - 1){
                builder.append(symbs[i]);
            }
            evaluateExpression(nums, symbs, numIndex+1, builder, result, target);

            builder.replace(numIndex*2, numIndex*2+2, "" );
        }
        numIndex--;

    }

    private boolean isValid(String str, int target){
        char[] arr = str.toCharArray();
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Character> symbs = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '+'){
                symbs.add(arr[i]);
            } else if(arr[i] == '*'){
                symbs.add(arr[i]);
            } else {
                StringBuilder builder = new StringBuilder();
                while( i < arr.length && (Character.isDigit(arr[i]) || arr[i] == ' ')) {
                    if(arr[i] != ' ') builder.append(arr[i]);
                    i++;
                }
                i--;
                numbers.add(Integer.parseInt(builder.toString()));
            }
        }

        int sum = numbers.remove();

        for(Character elem: symbs){
            if(elem == '+'){
                sum += numbers.remove();
            } else {
                sum *= numbers.remove();
            }
        }

        return sum == target;
    }



    public static void main(String[] args) {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        String str = "222";
        List<String> result = evaluator.evaluateExpression(str, 24);
        for(String elem : result){
            System.out.println(elem);
        }
    }

}
