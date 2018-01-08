package Algos;

public class FiveFourThree_Diameter_of_Binary_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.

    // method without using member field
    private static int rec(TreeNode node, final int[] max) {
        if (node == null) {
            return 0;
        }

        int left = rec(node.left, max), right = rec(node.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        final int[] max = {0};
        rec(root, max);
        return max[0];
    }

    // method with using a member field - ans
//    private int ans;
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        getHeight(root);
//        return ans;
//
//    }
//
//    private int getHeight(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//        ans = Math.max(ans, left + right);
//        return 1 + Math.max(left, right);
//    }
}
