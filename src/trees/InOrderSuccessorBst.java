package trees;

/**
 * Created by sergei.kostin on 3/7/18.
 */
public class InOrderSuccessorBst {

    public BinarySearchTree.TreeNode findSuccessor(BinarySearchTree.TreeNode root, int target){
        return findSuccessor(root, target, null);
    }

    private BinarySearchTree.TreeNode findMin(BinarySearchTree.TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    private BinarySearchTree.TreeNode findSuccessor(BinarySearchTree.TreeNode root, int target, BinarySearchTree.TreeNode leftResult){
        if(root == null) return null;
        if(root.value > target) return findSuccessor(root.left, target, root);
        else if(root.value < target) return findSuccessor(root.right, target, leftResult);
        else{
            if(root.right != null) return findMin(root.right);
            else return leftResult;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(40);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(80);

        tree.printInOrder(tree.getRoot());

        InOrderSuccessorBst inOrderSuccessorBst = new InOrderSuccessorBst();
        System.out.println();
        System.out.println(inOrderSuccessorBst.findSuccessor(tree.getRoot(), 60));
    }
}
