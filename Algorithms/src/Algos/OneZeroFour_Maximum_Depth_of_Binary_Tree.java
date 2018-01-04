package Algos;

public class OneZeroFour_Maximum_Depth_of_Binary_Tree {

    //Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // traverse
    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // traverse
        inOrder(root, 1);
        // traverse
        return depth;

        // divide conquer
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // return 1+Math.max(left,right);
    }

    // traverse
    private void inOrder(TreeNode root, int count) {
        if (root == null) {
            return;
        }

        inOrder(root.left, count + 1);

        if (depth < count) {
            depth = count;
        }

        inOrder(root.right, count + 1);
    }


}
