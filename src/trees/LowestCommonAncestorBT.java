package trees;

/**
 * Created by sergei.kostin on 1/4/18.
 */
public class LowestCommonAncestorBT {

    public BinarySearchTree.TreeNode lowestCommonAncestor(BinarySearchTree.TreeNode root, int a, int b){

        if(root == null) return null;
        if(root.value == a || root.value == b) return root;

        BinarySearchTree.TreeNode left = lowestCommonAncestor(root.left, a, b);
        BinarySearchTree.TreeNode right = lowestCommonAncestor(root.right, a, b);
        if(left != null && right!= null) return root;
        if(left == null && right == null) return null;
        return left == null ? right : left;
    }


    public static void main(String[] args) {
        LowestCommonAncestorBT lc= new LowestCommonAncestorBT();
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(30);
        bst.insert(45);
        bst.insert(35);
        bst.insert(55);
        bst.insert(15);
        bst.insert(10);
        bst.insert(5);
        bst.insert(25);
        System.out.println(lc.lowestCommonAncestor(bst.getRoot(), 35, 55));
    }


}
