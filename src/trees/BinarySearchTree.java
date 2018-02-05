package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sergei.kostin on 1/4/18.
 */
public class BinarySearchTree {

    private TreeNode root;

    public TreeNode getRoot(){
        return root;
    }

    public void insert(int val){
        insert(val, getRoot());
    }

    public void insert(int val, TreeNode root ){
        if(root == null){
            this.root = new TreeNode(val);
        } else if( val > root.value){
            if(root.right == null){
                root.right = new TreeNode(val);
            } else {
                insert(val, root.right);
            }
        } else {
            if(root.left == null){
                root.left = new TreeNode(val);
            } else {
                insert(val, root.left);
            }
        }
    }

    public void printInOrder(TreeNode root){
        if(root == null) return;
        printInOrder(root.left);
        System.out.print(root.value + "->");
        printInOrder(root.right);
    }

    public void printPreOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.value + "->");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printPostOrder(TreeNode root){
        if(root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value + "->");
    }

    public void printLevelOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            System.out.println(node);
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
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

    public boolean lookup(int val, TreeNode root){
        if(root == null) return false;
        if(root.value == val ) return true;
        if(val > root.value) return lookup(val, root.right);
        else return lookup(val, root.left);
    }

    public int size(TreeNode root){
        if(root == null) return 0;
        int sizeLeft = size(root.left);
        int sizeRight = size(root.right);
        return sizeLeft + sizeRight + 1;
    }

    public int minValue(TreeNode root){
        if(root == null) return 0;
        while(root.left != null){
            root = root.left;
        }
        return root.value;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth , rightDepth) + 1;
    }

    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null) return false;
        if((sum - root.value) == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
    }

    public void mirror(TreeNode root){
        if(root == null) return;
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    public void doubleTree(TreeNode root){
        if(root == null) return;
        addLeftChild(root);
        doubleTree(root.left.left);
        doubleTree(root.right);
    }

    private void addLeftChild(TreeNode root) {
        TreeNode newNode = new TreeNode(root.value);
        TreeNode temp = root.left;
        root.left = newNode;
        newNode.left = temp;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int leftBound, int rightBound){
        if(root == null) return true;
        if(root.value < leftBound || root.value>rightBound) return false;
        return (isValidBST(root.left, leftBound, root.value) && isValidBST(root.right, root.value, rightBound));
    }

    private void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.value = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(30);
        bst.insert(45);
        bst.insert(35);
        bst.insert(55);
        bst.insert(15);
        bst.insert(10);
        bst.insert(5);
        bst.insert(25);
        bst.printPostOrder(bst.getRoot());
    }


}
