package Algos;

public class FiveThreeZero_Minimum_Absolute_Difference_in_BST {

    class Node {
        Node left;
        Node right;
        int val;

        Node(int x) {
            val = x;
        }
    }

    int min = Integer.MAX_VALUE;
    int prev = -1;

    // time complexity: O(n)
    // space complexity: O(1)
    public int getMinimumDifference(Node root) {

        // in order traverse

        if (root == null) {
            return min;
        }

        getMinimumDifference(root.left);

        if (prev != -1) {
            min = Math.min(min, Math.abs(root.val - prev));
        }

        prev = root.val;

        getMinimumDifference(root.right);

        return min;

    }

}
