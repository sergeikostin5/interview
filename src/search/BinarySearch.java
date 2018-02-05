package search;

/**
 * Created by sergei.kostin on 12/26/17.
 */
public class BinarySearch {

    public int search(int[] arr, int number){
        return search(arr, 0, arr.length - 1, number);
    }

    private int search(int[] arr, int start, int end, int number) {

        if(start > end) return -1;

        int mid = start + (end - start)/2;
        if(arr[mid] == number) return mid;
        else if(number > mid) return search(arr, mid + 1, end, number);
        else return search(arr, start, mid - 1, number);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,9};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(arr,5));
    }

}
