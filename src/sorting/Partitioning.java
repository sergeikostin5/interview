package sorting;

import utils.ArrayHelper;

/**
 * Created by sergei.kostin on 12/22/17.
 */
public class Partitioning {

    public int partition( int[] array, int left, int right ){
        int pivot = left;
        int i = left +1;
        int j = right;
        while(i<j)
        {
            // shift i to right until array[i] >=array[pivot]
            while(i<=j && array[pivot]>=array[i])
            {
                i++;
            }
            //shift j to left until array[j] < array[pivot]
            while(j>=i && array[pivot]<array[j])
            {
                j--;
            }
            if(i < j && array[i]>array[j])
            {
                swap(array,i++,j--);
            }
        }
        if(array[pivot] > array[j]){
            swap(array,j,pivot);
        }
        return j;

    }

    private void swap( int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {4,3,9,8,5,2,7,1,6};
        ArrayHelper.printArrayWithIndexes(arr);
        Partitioning part = new Partitioning();
        int pivot = part.partition( arr, 0, arr.length - 1 );
        System.out.println(pivot);
        ArrayHelper.printArrayWithIndexes(arr);
//        pivot = part.partition( arr, 0, 7 );
//        System.out.println(pivot);
//        ArrayHelper.printArrayWithIndexes(arr);
    }

}
