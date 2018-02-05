package trees;

/**
 * Created by sergei.kostin on 1/27/18.
 */
public class IsBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

      public static boolean isValidBST(TreeNode root) {
            // return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
            Integer current = Integer.MIN_VALUE;
            return isValidBST(root, current);
        }

        private static boolean isValidBST(TreeNode root, Integer current ){
            if (root == null) return true;
            boolean left = isValidBST(root.left, current );
            boolean right;
            if(root.val < current || current.equals(root.val)) right = false;
            else {
                current = root.val;
                right = isValidBST(root.right, current);
            }
            return left && right;
        }

        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) return true;
            if (root.val >= maxVal || root.val <= minVal) return false;
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        root.left = left;
        System.out.println(isValidBST(root));

    }
}