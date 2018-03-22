package search;

/**
 * Created by sergei.kostin on 2/16/18.
 */
public class SearchRecurence {

    public int reccurance(int[] nums, int k){
        int right = reccuranceRight(nums, k, 0, nums.length-1);
        int left = reccuranceLeft(nums, k, 0, nums.length-1);
        return right - left + 1;
    }

    private int reccuranceRight(int[] nums, int k, int start, int end) {

        if(start > end) return end;
        int mid = start + (end - start)/2;
        if(nums[mid] <= k){
            return reccuranceRight(nums, k, mid+1, end);
        }else{
            return reccuranceRight(nums, k, start, end-1);
        }
    }

    private int reccuranceLeft(int[] nums, int k, int start, int end) {

        if(start > end) return start;
        int mid = start + (end - start)/2;
        if(nums[mid] >= k){
            return reccuranceLeft(nums, k, start, mid-1);
        }else{
            return reccuranceLeft(nums, k, mid+1, end);
        }
    }



    public static void main(String[] args) {
        SearchRecurence sr = new SearchRecurence();
        int[] nums = {0,0,0,1,2,5,6};
        System.out.println(sr.reccurance(nums, 6));
    }

}
