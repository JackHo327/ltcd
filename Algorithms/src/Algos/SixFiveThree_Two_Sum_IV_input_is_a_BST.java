package Algos;

import java.util.HashSet;

class SixFiveThree_Two_Sum_IV_input_is_a_BST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    private boolean ret = false;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        traverse(root, set, k);
        return ret;
    }

    public void traverse(TreeNode toVisit, HashSet<Integer> set, int k) {
        if (toVisit != null) {
            traverse(toVisit.left, set, k);
            traverse(toVisit.right, set, k);
            if (set.contains(toVisit.val)) {
                ret = true;
            }
            set.add(k - toVisit.val);
        }

    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
