package trees;

/**
 * Created by sergei.kostin on 4/3/18.
 */
public class TreeTopView {

    void goLeft(BinarySearchTree.TreeNode node) {
        if(node.left != null) {
            goLeft(node.left);
        }
        System.out.print(node.value + " ");
    }

    void goRight(BinarySearchTree.TreeNode node) {
        System.out.print(node.value + " ");

        if(node.right != null) {
            goRight(node.right);
        }
    }

    void topView(BinarySearchTree.TreeNode root) {
        if(root.left != null) {
            goLeft(root.left);
        }

        System.out.print(root.value + " ");

        if(root.right != null) {
            goRight(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(80);
        tree.insert(75);
        tree.insert(65);
        tree.insert(60);
        TreeTopView treeTopView = new TreeTopView();
        treeTopView.topView(tree.getRoot());
    }




}
