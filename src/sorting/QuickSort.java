package sorting;

import utils.ArrayHelper;

/**
 * Created by sergei.kostin on 12/23/17.
 */
public class QuickSort {

    Partitioning partitioning = new Partitioning();

    public void sort( int[] arr ){
        sort(arr, 0, arr.length - 1);
    }

    private void sort( int[] arr, int left, int right ){
        if(left >= right) return;
        int pivot = partitioning.partition(arr, left, right);
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {15,3,9,8,8,8,5,2,7,1,6,6};
        QuickSort qs = new QuickSort();
        qs.sort(arr);
        System.out.println("Sorted Array: ");
        ArrayHelper.printArrayWithIndexes(arr);
    }

}
