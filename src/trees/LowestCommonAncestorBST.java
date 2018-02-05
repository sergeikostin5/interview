package trees;

/**
 * Created by sergei.kostin on 1/5/18.
 */
public class LowestCommonAncestorBST {

    public BinarySearchTree.TreeNode findLowest(BinarySearchTree.TreeNode root, int a, int b){

        while(root != null){
            if(root.value == a || root.value == b) return root;
            else if ((root.value > a && root.value < b) || (root.value < a && root.value > b) ) return root;
            else if (root.value > a && root.value > b ) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;

    }


    public static void main(String[] args) {

        LowestCommonAncestorBST lc = new LowestCommonAncestorBST();
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(40);
        bst.insert(70);
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(25);
        bst.insert(27);
        bst.insert(60);
        bst.insert(80);
        bst.insert(65);
        System.out.println(lc.findLowest(bst.getRoot(), 30, 60));
    }

}
