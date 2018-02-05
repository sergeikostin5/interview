package trees;

/**
 * Created by sergei.kostin on 1/5/18.
 */
public class CloneBinaryTree {

    public BinarySearchTree.TreeNode cloneTree(BinarySearchTree.TreeNode root){
        if(root == null) return null;
        BinarySearchTree.TreeNode cRoot = new BinarySearchTree.TreeNode(root.value);
        cloneTree(root, cRoot);
        return cRoot;
    }

    public void cloneTree(BinarySearchTree.TreeNode root, BinarySearchTree.TreeNode cRoot){
        if(root.left != null){
            cRoot.left = new BinarySearchTree.TreeNode(root.left.value);
            cloneTree(root.left, cRoot.left);
        }
        if(root.right != null){
            cRoot.right = new BinarySearchTree.TreeNode(root.right.value);
            cloneTree(root.right, cRoot.right);
        }
    }


    public static void main(String[] args) {
        CloneBinaryTree cl = new CloneBinaryTree();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(40);
        bst.insert(60);
        bst.insert(20);
        bst.insert(15);
        bst.insert(27);
        bst.insert(25);
        bst.insert(45);
        BinarySearchTree.TreeNode newNode = cl.cloneTree(bst.getRoot());
        bst.printLevelByLevel(bst.getRoot());
        System.out.println();
        bst.printLevelByLevel(newNode);
    }
}
