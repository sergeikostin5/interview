package recursion;

/**
 * Created by sergei.kostin on 1/1/18.
 */
public class SubsetOfSet {

    public void printSubsets(char[] arr){
        char[] result = new char[arr.length];
        printSubsets(arr, 0, result,0);
    }

    private void printSubsets(char[] arr, int level, char[] result, int r_size){
        if(level == arr.length){
            printSub(result, r_size);
            return;
        }
        printSubsets(arr, level + 1, result, r_size);
        result[r_size] = arr[level];
        printSubsets(arr,level+1, result, r_size+1);


    }

    private void printSub(char[] result, int r_size){
        for(int i = 0; i < r_size; i++){
            System.out.print(result[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] arr = {'a','b','c'};
        SubsetOfSet ss = new SubsetOfSet();
        ss.printSubsets(arr);
    }

}
