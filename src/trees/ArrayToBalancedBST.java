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
        a.arrayToTree(arr);
    }




    public BinarySearchTree.TreeNode arrayToTree(int[] array){
        BinarySearchTree tree = new BinarySearchTree();
        arrayToTree(array, tree, 0, array.length - 1);
        tree.printLevelByLevel(tree.getRoot());
        return tree.getRoot();
    }

    private void arrayToTree(int[] array, BinarySearchTree tree, int start, int end){
        if(start > end) return;
        int mid = (start + end)/2;
        tree.insert(mid);
        arrayToTree(array, tree, mid+1, end);
        arrayToTree(array, tree, start, mid - 1);
    }


}

