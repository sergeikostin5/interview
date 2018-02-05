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

        bst.insert(30);
        bst.insert(15);
        IsBalancedBT bt = new IsBalancedBT();
        System.out.println(bt.isBST(bst.getRoot(), 0));
    }

    private static class Helper{
        static boolean isInit;
        static int height;
    }

}
