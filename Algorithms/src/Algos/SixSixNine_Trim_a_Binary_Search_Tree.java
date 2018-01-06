package Algos;

public class SixSixNine_Trim_a_Binary_Search_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return root;
        }

        // judge the current node
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        // main recursion
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
