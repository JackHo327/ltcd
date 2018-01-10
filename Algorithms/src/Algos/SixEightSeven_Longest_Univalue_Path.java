package Algos;

public class SixEightSeven_Longest_Univalue_Path {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int len = 0; // global variable

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        len = 0;
        getLen(root, root.val);
        return len;
    }

    private int getLen(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);

        len = Math.max(len, left + right);

        if (val == node.val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}

