package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sergei.kostin on 12/26/17.
 */
public class HeapSort {

    public void sort(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer elem : arr){
            pq.add(elem);
        }

        for(int i =0; i<arr.length; i++){
            arr[i] = pq.poll();
        }
    }

    public static void main(String[] args) {

        int[] arr = {15,3,9,8,8,48,8,5,2,7,1,6,6,22,34};
        HeapSort hs = new HeapSort();
        hs.sort(arr);
        System.out.println(Arrays.toString(arr));


    }

}
