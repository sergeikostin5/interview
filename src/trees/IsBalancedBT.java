package trees;

/**
 * Created by sergei.kostin on 1/8/18.
 */
public class IsBalancedBT {

    public boolean isBST(BinarySearchTree.TreeNode root, int size){
        if(root == null){
            if(!Helper.isInit){
                Helper.isInit = true;
                Helper.height = size;
                return true;
            }else{
                return Math.abs(Helper.height - size) <=1;
            }
        }
        boolean left = isBST(root.left, size+1);
        boolean right = isBST(root.right, size+1);
        return left && right;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(40);
        bst.insert(20);
        bst.insert(30);
        bst.insert(10);
        bst.insert(5);
        bst.insert(70);
   
        IsBalancedBT bt = new IsBalancedBT();
        System.out.println(bt.isBST(bst.getRoot()));
    }

    public boolean isBST(BinarySearchTree.TreeNode root){
        if(maxDiffHeight(root) == -1) return false;
        else return true;
    }

    private int maxDiffHeight(BinarySearchTree.TreeNode root){
        if(root == null) return 0;
        int left = maxDiffHeight(root.left);
        int right = maxDiffHeight(root.right);
        if(left == -1 || right == -1) return -1;
        else if(Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) +1;
    }

    private static class Helper{
        static boolean isInit;
        static int height;
    }


//            40
//          /    \
//         20    70
//        /  \
//       10   30
//       /
//      5
}
