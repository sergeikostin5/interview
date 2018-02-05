package search;

/**
 * Created by sergei.kostin on 12/26/17.
 */
public class SearchSortedRotatedArray {

    public int findPivot(int[] arr){
        if(arr.length < 2) return -1;
        if(arr[0] < arr[arr.length - 1]) return -1;
        return findPivot(arr, 0, arr.length - 1);
    }

    private int findPivot(int[] arr, int start, int end) {
        if(start > end ) return -1;

        int mid = start + (end - start)/2;
        if(arr[mid] > arr[mid+1]) return mid;
        else if(arr[mid] > arr[end]) {
            return findPivot(arr, mid, end);
        } else return findPivot(arr, start, mid);
    }

    public int search(int[] nums, int target){
        int pivot = findPivot(nums);
        System.out.println(pivot);
        if( pivot == -1) return search(nums, 0, nums.length - 1, target);
        else if (target >= nums[0] && target <=nums[pivot]) return search(nums, 0, pivot, target);
        else return search(nums, pivot+1, nums.length - 1, target);
    }

    private int search(int[] arr, int start, int end, int number){
        if(start > end ) return -1;

        int mid = start+(end - start)/2;

        if(number > arr[mid]) return search(arr, mid+1, end, number);
        else if(number <arr[mid]) return search(arr, start, mid - 1, number);
        return mid;

    }

    public static void main(String[] args) {
        int[] arr = {6,7,8,1,2,3,4,5};
        SearchSortedRotatedArray ss = new SearchSortedRotatedArray();
        System.out.println(ss.search(arr,6));
    }

}
