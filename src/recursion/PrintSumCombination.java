package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 11/12/17.
 */
public class PrintSumCombination {

//    https://leetcode.com/problems/combination-sum/description/
    public static void main(String[] args) {

        PrintSumCombination psc = new PrintSumCombination();
        int[] arr = new int[]{2,3,6,7};
        List<List<Integer>> result = psc.printSum(arr, 7);
        for(List<Integer> list : result){
            System.out.println(list);
        }

    }

    public List<List<Integer>> printSum(int[] input, int target){
        List<List<Integer>> result = new ArrayList<>();
        printSum(input, target, 0, new ArrayList<>(), result, 0);
        return result;
    }

    private void printSum(int[] input, int target, int curSum, List<Integer> tempList, List<List<Integer>> result, int start){
        if(curSum == target) {
            List<Integer> list = new ArrayList<>(tempList);
            result.add(list);
            return;
        }
        if(curSum > target){
            return;
        }
        for(int i = start; i < input.length; i++){
            tempList.add(input[i]);
            printSum(input, target, curSum + input[i], tempList, result, start);
            start++;
            tempList.remove(tempList.size() - 1);
        }
    }


}
