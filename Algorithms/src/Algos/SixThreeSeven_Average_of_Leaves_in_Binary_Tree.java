package Algos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SixThreeSeven_Average_of_Leaves_in_Binary_Tree {
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();

        if (root == null) {
            return list;
        }


        Deque<TreeNode> myQueue = new ArrayDeque<>();

        myQueue.offer(root);

        double avg = 0.0;
        int counter = 0;

        // BFS
        while (!myQueue.isEmpty()) {
            Deque<TreeNode> subQueue = new ArrayDeque<>();

            while (!myQueue.isEmpty()) {
                TreeNode tmp = myQueue.poll();
                avg += tmp.val;
                counter++;
                if (tmp.left != null) {
                    subQueue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    subQueue.offer(tmp.right);
                }
            }

            list.add(avg / counter);
            myQueue = subQueue;
            avg = 0.0;
            counter = 0;
        }

        return list;

    }
}
