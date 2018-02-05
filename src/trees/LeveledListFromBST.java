package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Cracking coding interview 4.4
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g. if you
 * have a tree with depth D, you would have D linked lists
 */
public class LeveledListFromBST {

    public void convertToList(BinarySearchTree.TreeNode root, int level, List<List<BinarySearchTree.TreeNode>> result){
        if(root == null) return;
        if(result.size() <= level){
            List<BinarySearchTree.TreeNode> temp = new LinkedList<>();
            temp.add(root);
            result.add(temp);
        } else {
            result.get(level).add(root);
        }
        convertToList(root.left, level+1, result);
        convertToList(root.right, level+1, result);
    }

    // using two queues
    public void convertToListBreadth(BinarySearchTree.TreeNode root, List<List<BinarySearchTree.TreeNode>> result){
        if(root == null) return;

        Queue<BinarySearchTree.TreeNode> q1 = new LinkedList<>();
        Queue<BinarySearchTree.TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        int level = 0;
        while(!q1.isEmpty() || !q2.isEmpty()){
            BinarySearchTree.TreeNode cur;
            while(!q1.isEmpty()){
                cur = q1.remove();
                if(result.size() == level){
                    List<BinarySearchTree.TreeNode> temp = new LinkedList<>();
                    result.add(temp);
                }
                result.get(level).add(cur);
                if(cur.left != null){
                    q2.add(cur.left);
                }
                if(cur.right != null){
                    q2.add(cur.right);
                }
            }
            level++;
            while(!q2.isEmpty()) {
                cur = q2.remove();
                if(result.size() == level){
                    List<BinarySearchTree.TreeNode> temp = new LinkedList<>();
                    result.add(temp);
                }
                result.get(level).add(cur);
                if(cur.left != null){
                    q1.add(cur.left);
                }
                if(cur.right != null){
                    q1.add(cur.right);
                }
            }
            level++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};
        ArrayToBalancedBST a = new ArrayToBalancedBST();
        BinarySearchTree tree = new BinarySearchTree();
        a.arrayToBst(arr,0, arr.length-1, tree);

        LeveledListFromBST lev = new LeveledListFromBST();
        List<List<BinarySearchTree.TreeNode>> result = new ArrayList<>();
        lev.convertToListBreadth(tree.getRoot(), result);
        for(List<BinarySearchTree.TreeNode> elem : result){
            System.out.println(elem);
        }
    }




}
