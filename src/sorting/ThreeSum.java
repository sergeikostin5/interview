package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero. The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        //{0,0,0}
//         ^ ^ ^

        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] > nums[i-1]){
                int start = i+1;
                int end = nums.length - 1;
                while(start < end){

                    if((nums[i] + nums[start] + nums[end]) == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        result.add(temp);
                    }
                    if((nums[i] + nums[start] + nums[end]) < 0){
                        int currentStart = nums[start];
                        while(nums[start] == currentStart && start<end){
                            start++;
                        }
                    } else {
                        int currentEnd = nums[end];
                        while(nums[end] == currentEnd && start<end){
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1,0,-1};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> result = ts.threeSum(arr);
        for(List<Integer> elem : result){
            System.out.println(elem);
        }

    }
}
