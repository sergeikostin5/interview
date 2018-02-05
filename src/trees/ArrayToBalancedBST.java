package trees;

import search.BinarySearch;

/**
 * Created by sergei.kostin on 1/4/18.
 */
public class ArrayToBalancedBST {

    public void arrayToBst(int[] arr, int lo, int hi, BinarySearchTree bst){
        if(lo > hi) return;

        int mid = lo + (hi - lo)/2;
        bst.insert(arr[mid]);
        arrayToBst(arr, lo, mid - 1, bst);
        arrayToBst(arr, mid+1, hi, bst);
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};
        ArrayToBalancedBST a = new ArrayToBalancedBST();
        BinarySearchTree tree = new BinarySearchTree();
        a.arrayToBst(arr,0, arr.length-1, tree);
        tree.printInOrder(tree.getRoot());
    }

}
