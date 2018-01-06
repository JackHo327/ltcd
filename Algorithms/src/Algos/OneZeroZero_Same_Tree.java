package Algos;

public class OneZeroZero_Same_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }

    }
}
