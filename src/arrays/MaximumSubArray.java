package arrays;

/**
 * Created by sergei.kostin on 3/12/18.
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for(int i =1; i < nums.length; i++){
            if(nums[i] > currentMax +nums[i]) currentMax = nums[i];
            else{
                currentMax = nums[i] + currentMax;

            }
            max = Math.max(max, currentMax);
        }
        return max;
    }

    public static int maxSubArraySum(int[] arr){
        if(arr == null || arr.length == 0 ) return 0;
        int max = arr[0];
        int curMax = max;
        for(int i = 1; i < arr.length - 1; i++){
            curMax = arr[i] + curMax;
            if(curMax < 0) {
                curMax = 0;
            }
            else{
                Math.max(curMax, max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {2, -8, 3, -2, 4, -10};
        System.out.println(maxSubArraySum(nums));
    }
}
