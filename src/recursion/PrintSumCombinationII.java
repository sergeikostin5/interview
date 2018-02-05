package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sergei.kostin on 11/12/17.
 */
public class PrintSumCombinationII {

    public static void main(String[] args) {
        PrintSumCombinationII psc = new PrintSumCombinationII();
        int[] input = new int[]{2, 2, 2};
        Arrays.sort(input);
        List<List<Integer>> result = psc.combinationSum2(input, 2);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2Util(candidates, target, 0, 0, result, new ArrayList<>());
        return result;
    }

    private void combinationSum2Util(int[] candidates, int target, int start, int curSum, List<List<Integer>> result, List<Integer> temp){
        if(curSum == target){
            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
            return;
        }
        if(curSum > target){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i == start && i<candidates.length-1  && candidates[i] == candidates[i+1]) continue;
            temp.add(candidates[i]);
            start = start+1;
            combinationSum2Util(candidates, target, start, curSum + candidates[i], result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
