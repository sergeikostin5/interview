package search;

/**
 * Created by sergei.kostin on 3/14/18.
 */
public class SearchRotatedSortedArray2 {

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        if(target >= nums[pivot] && target <= nums[nums.length-1]){
            return search(nums, target, pivot, nums.length -1);
        }else{
            return search(nums, target, 0, pivot -1);
        }
    }



    private int findPivot(int[] nums, int start, int end) {

        if(start > end) return 0;
        int mid = (start+end)/2;

        if(mid > 0 && nums[mid-1] > nums[mid]) return mid;

        if(nums[mid] <= nums[end]){ // right side is sorted, go left
            return findPivot(nums, start, mid - 1);
        }else{ // left side is sorted go right
            return findPivot(nums, mid+1, end);
        }
    }

    private int search(int[] nums, int target, int start, int end ){
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target){
            return search(nums, target, start, mid - 1);
        }else{
            return search(nums, target, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3};

        SearchRotatedSortedArray2 search = new SearchRotatedSortedArray2();
        System.out.println(search.search(arr, 3));
    }

}
