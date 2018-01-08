package Algos;

import java.util.*;

public class OneZeroSeven_Binary_Tree_Level_Order_Traversal_II {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // DFS - recursion
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
//        levelMaker(wrapList, root, 0);
//        return wrapList;
//    }
//
//    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
//        if (root == null) return;
//        if (level >= list.size()) {
//            list.add(0, new LinkedList<Integer>());
//        }
//        levelMaker(list, root.left, level + 1);
//        levelMaker(list, root.right, level + 1);
//// add the root.val into its corresponding level-indexed list
//        list.get(list.size() - level - 1).add(root.val);
//    }


    // BFS - iteration
    private List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // if root is null
        if (root == null) {
            return list;
        }

        Deque<TreeNode> myQueue = new ArrayDeque<>();
//        Deque<List<Integer>> tmpStack = new ArrayDeque<>();

        myQueue.offer(root);
        // another way for BFS -- do not handle the root separately
        // while(!queue.isEmpty()){
        //     int levelNum = queue.size();
        //     List<Integer> subList = new LinkedList<Integer>();
        //     for(int i=0; i<levelNum; i++) {
        //     peek the head and see whether there is left or right node
        //         if(queue.peek().left != null) queue.offer(queue.peek().left);
        //         if(queue.peek().right != null) queue.offer(queue.peek().right);
        //     add the current head into the subList by poll it out from the queue.
        //         subList.add(queue.poll().val);
        //     }
        //     wrapList.add(0, subList);
        // }
        List<Integer> subList = new ArrayList<>();
        subList.add(root.val);
        list.add(0, subList);
//        tmpStack.push(subList);

        // BFS
        while (!myQueue.isEmpty()) {
            Deque<TreeNode> subQueue = new ArrayDeque<>();
            subList = new ArrayList<>();
            while (!myQueue.isEmpty()) {
                TreeNode tmp = myQueue.poll();
                // add left kid
                if (tmp.left != null) {
                    subQueue.add(tmp.left);
                    subList.add(tmp.left.val);
                }
                // add right kid
                if (tmp.right != null) {
                    subQueue.add(tmp.right);
                    subList.add(tmp.right.val);
                }
            }
            myQueue = subQueue;
            if (subList.size() > 0) {
//                tmpStack.push(subList);
                list.add(0, subList);
            }

        }

//        this loop and tmpStack can be saved by using list.add(index, element) - here the index should be 0 -- directly add the new list in the first position
//        while (!tmpStack.isEmpty()) {
//            list.add(tmpStack.pop());
//        }

        return list;
    }

}
