package arrays;

import java.util.Arrays;

/**
 * Created by sergei.kostin on 3/14/18.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] A) {
        if (A.length==0) return 0;
        int j=0;
        for (int i=0; i<A.length; i++){
            if (A[i]!=A[j]) {
                j++;
                A[j]=A[i];
            }
        }
        j++;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,};
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(arr));

        System.out.println(Arrays.toString(arr));
    }

}
