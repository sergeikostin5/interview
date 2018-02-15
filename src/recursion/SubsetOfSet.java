package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 1/1/18.
 */
public class SubsetOfSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] subResult = new int[nums.length];
        subsets(nums, result, subResult, 0, 0);
        return result;
    }

    private void subsets(int[] nums, List<List<Integer>> result, int[] subResult, int level, int res_size) {
        if(level == subResult.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i< res_size; i++){
                temp.add(subResult[i]);
            }
            result.add(temp);
            return;
        }
        subResult[res_size] = nums[level];
        subsets(nums, result, subResult, level+1, res_size+1);
        subsets(nums, result, subResult, level+1, res_size);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        SubsetOfSet ss = new SubsetOfSet();
        List<List<Integer>> list = ss.subsets(arr);
        for(List<Integer> elem : list){
            System.out.println(elem);
        }
    }









//    private void printSubsets(char[] arr, int level, char[] result, int r_size){
//        if(level == arr.length){
//            printSub(result, r_size);
//            return;
//        }
//        printSubsets(arr, level + 1, result, r_size);
//        result[r_size] = arr[level];
//        printSubsets(arr,level+1, result, r_size+1);
//
//
//    }
//
//    private void printSub(char[] result, int r_size){
//        for(int i = 0; i < r_size; i++){
//            System.out.print(result[i]);
//        }
//        System.out.println();


}
