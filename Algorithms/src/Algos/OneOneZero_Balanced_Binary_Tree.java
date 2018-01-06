package Algos;

public class OneOneZero_Balanced_Binary_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return 1 + Math.max(leftHeight, rightHeight);
        } else {
            return -1;
        }
    }


}
