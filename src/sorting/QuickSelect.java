package sorting;

/**
 * Created by sergei.kostin on 12/23/17.
 */
public class QuickSelect {

    private Partitioning partitioning = new Partitioning();

    public int findKthelement(int[] arr, int k ){

        if( k >= arr.length || arr.length == 0) throw new IllegalArgumentException();
        return findKthelement( arr, k, 0, arr.length - 1);
    }

    private int findKthelement(int[] arr, int k, int left, int right ){

        int pivot = partitioning.partition( arr, left, right);

        if ( k < pivot ) return findKthelement( arr, k, left, pivot - 1);

        else if ( k > pivot ) return findKthelement( arr, k, pivot + 1, right);

        return arr[pivot];

    }

    public static void main(String[] args) {
        int[] arr = {15,3,9,8,5,2,7,1,6};
        QuickSelect qs = new QuickSelect();
        System.out.println("biggest element is: " + qs.findKthelement(arr, 5));

    }


}
