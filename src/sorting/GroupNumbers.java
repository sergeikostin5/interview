package sorting;

import java.util.Arrays;

/**
 * Group even integers on the left side of array and odd on the right
 */
public class GroupNumbers {

    public int[] groupNumbers(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            while( i < arr.length - 1 && isEven(arr[i]) ){
                i++;
            }
            while( j > 0 && !isEven(arr[j]) ){
                j--;
            }
            if(i<j && isEven(arr[j]) && !isEven(arr[i])){
                swap(arr, i, j);
            }
        }
        if(isEven(arr[i]) && !isEven(arr[j])){
            swap(arr, i, j);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isEven(int num){
        return num%2 == 0;
    }


    public static void main(String[] args) {
        GroupNumbers gn = new GroupNumbers();
        int[] arr = {4,1,2,3,4};
        gn.groupNumbers(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {5,1,3,5,4,6};
        gn.groupNumbers(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {6,4,5,3,1};
        gn.groupNumbers(arr3);
        System.out.println(Arrays.toString(arr3));

    }

}
