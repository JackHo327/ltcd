package Algos;

public class FiveSixThree_Binary_Tree_Tilt {
    
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int sum = 0;

    public int findTilt(TreeNode root) {
        postorder(root);
        return sum;
    }

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int right = postorder(root.right);
        int left = postorder(root.left);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

}
