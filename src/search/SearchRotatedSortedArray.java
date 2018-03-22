package search;

/**
 * Created by sergei.kostin on 3/14/18.
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end){
        if(start>end) return -1;
        int mid = start + (end-start)/2;
        if(nums[mid] == target) return mid; //Case 1: we found it
        else if(nums[mid] <= nums[end]){ // Case 2: right part is sorted
            if(target > nums[mid] && target <= nums[end]){
                start = mid+1;
            } else {
                end = mid - 1;
            }
        } else { // Case 3: left part is sorted
            if(target < nums[mid] && target >= nums[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return search(nums, target, start, end);
    }

}
