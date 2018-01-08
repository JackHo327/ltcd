package Algos;

public class OneZeroEight_Convert_Sorted_Array_to_Binary_Search_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = getMidNode(nums, 0, nums.length - 1);

        return root;
    }


    private TreeNode getMidNode(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getMidNode(nums, l, mid - 1);
        root.right = getMidNode(nums, mid + 1, r);

        return root;
    }

}
