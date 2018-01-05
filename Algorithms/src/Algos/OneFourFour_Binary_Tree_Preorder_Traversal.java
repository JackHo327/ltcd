package Algos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OneFourFour_Binary_Tree_Preorder_Traversal {
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return list;
        }

        // iteration - DFS -- Pre Order Traversal
        Deque<TreeNode> myDeque = new ArrayDeque<>();
        myDeque.push(root);

        while (!myDeque.isEmpty()) {
            TreeNode tmp = myDeque.pop();
            list.add(tmp.val);
            if (tmp.right != null) {
                myDeque.push(tmp.right);
            }
            if (tmp.left != null) {
                myDeque.push(tmp.left);
            }
        }

        // recursion
        // preOrder(root);
        return list;

    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }
    
}
