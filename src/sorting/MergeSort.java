package sorting;

import java.util.Arrays;

/**
 * Created by sergei.kostin on 12/25/17.
 */
public class MergeSort {

    public void merge(int[] arr, int left, int mid, int right){
        int[] aux = new int[arr.length];

        for(int i = left; i <= right; i++){
            aux[i] = arr[i];
        }
        int i = left;
        int j = mid;
        for(int k = left; k <= right; k++){
            if(i >= mid) arr[k] = aux[j++];
            else if (j>right) arr[k] = aux[i++];
            else if (aux[i] < aux[j]) arr[k] = aux[i++];
            else arr[k]=aux[j++];
        }
    }

    public void sort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right){

        if( left >= right ) return;
        int mid = left + (right - left)/2;
        sort(arr, left, mid );
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }


    public static void main(String[] args) {
//        int[] arr = {2,3,9,10,1,6,7,8,11,15};
//        int[] arr = {5};
        MergeSort ms = new MergeSort();
//        ms.merge(arr, 0, 0, 0);
//        System.out.println(Arrays.toString(arr));

//        ms.merge(arr, 0, 4, arr.length - 1);
        int[] arr = {34,2,45,6,3,1,1,4,7,8,9};
        ms.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
