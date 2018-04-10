package interviews.facebook_friends;

import java.util.Arrays;

/**
 * Created by sergei.kostin on 4/4/18.
 */
public class PartitionOddEven {

    public void partition(int[] arr){
        int i = 0; int j = arr.length - 1;
        while (i < j){
            if(arr[i]%2 != 0 && arr[j]%2 == 0){
                i++; j--;
            } else if(arr[i]%2 == 0 && arr[j]%2 != 0){
                swap(arr, i, j);
                i++; j--;
            } else if(arr[i]%2 == 0) j--;
            else i++;
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) {
        int[] arr = {3,3,4,4,1,10,6,8,9,10,11,34,12,15,17};
        PartitionOddEven poe = new PartitionOddEven();
        poe.partition(arr);
        System.out.println(Arrays.toString(arr));
    }

}
