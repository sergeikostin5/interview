package trees;

import search.BinarySearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sergei.kostin on 1/5/18.
 */
public class MergeTwoBST {

    public BinarySearchTree.TreeNode mergeTrees(BinarySearchTree.TreeNode n1, BinarySearchTree.TreeNode n2) {
        List<BinarySearchTree.TreeNode> arrayTree1 = parseTree(n1);
        List<BinarySearchTree.TreeNode> arrayTree2 = parseTree(n2);
        List<BinarySearchTree.TreeNode> mergedArray = new ArrayList<>();
        mergeArrays(arrayTree1, arrayTree2, mergedArray);
        System.out.println(mergedArray);
        BinarySearchTree bst = new BinarySearchTree();
        convertArrayToBST(mergedArray, bst);
        bst.printInOrder(bst.getRoot());
        System.out.println();
        printLevelByLevel(bst.getRoot());
        System.out.println();
        return bst.getRoot();

    }

    private void convertArrayToBST(List<BinarySearchTree.TreeNode> mergedArray, BinarySearchTree bst) {
        convertArrayToBST( mergedArray, bst, 0, mergedArray.size() - 1 );
    }

    private void convertArrayToBST(List<BinarySearchTree.TreeNode> mergedArray, BinarySearchTree bst, int lo, int hi) {
        if(lo > hi) return;

        int mid = lo + (hi - lo)/2;

        bst.insert(mergedArray.get(mid).value);
        convertArrayToBST(mergedArray, bst, lo, mid -1);
        convertArrayToBST(mergedArray, bst, mid+1, hi);
    }

    private void mergeArrays(List<BinarySearchTree.TreeNode> arrayTree1, List<BinarySearchTree.TreeNode> arrayTree2, List<BinarySearchTree.TreeNode> mergedArray) {
        int start1 = 0;
        int start2 = 0;
        while(start1 < arrayTree1.size() && start2 < arrayTree2.size()){
            if(arrayTree1.get(start1).value <= arrayTree2.get(start2).value){
                mergedArray.add(arrayTree1.get(start1));
                start1++;
            } else {
                mergedArray.add(arrayTree2.get(start2));
                start2++;
            }
        }
        while(start1 < arrayTree1.size()){
            mergedArray.add(arrayTree1.get(start1));
            start1++;
        }
        while(start2 < arrayTree2.size()){
            mergedArray.add(arrayTree2.get(start2));
            start2++;
        }
    }

    private List<BinarySearchTree.TreeNode> parseTree(BinarySearchTree.TreeNode n1){
        ArrayList<BinarySearchTree.TreeNode> result = new ArrayList<>();
        inorderTraversal(n1, result);
        return result;
    }

    private void inorderTraversal(BinarySearchTree.TreeNode root, List<BinarySearchTree.TreeNode> result){
        if(root == null) return;
        inorderTraversal(root.left, result);
        result.add(root);
        inorderTraversal(root.right, result);

    }

    public void printLevelByLevel(BinarySearchTree.TreeNode root){
        Queue<BinarySearchTree.TreeNode> q = new LinkedList();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            BinarySearchTree.TreeNode node = q.remove();
            if(node == null && !q.isEmpty()) {
                System.out.println();
                q.add(null);
            } else {
                if(node == null) return;
                System.out.print(node.value + " ");
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        MergeTwoBST mr = new MergeTwoBST();
        BinarySearchTree bst1 = new BinarySearchTree();
        BinarySearchTree bst2 = new BinarySearchTree();
        bst1.insert(2);
        bst1.insert(3);
        bst1.insert(1);
        bst2.insert(7);
        bst2.insert(8);
        bst2.insert(6);
        mr.mergeTrees(bst1.getRoot(), bst2.getRoot());
        BinarySearchTree bst3 = new BinarySearchTree();
        bst3.insert(6);
        bst3.insert(2);
        bst3.insert(7);
        bst3.insert(1);
        bst3.insert(3);
        bst3.insert(8);
        mr.printLevelByLevel(bst3.getRoot());

    }

}
