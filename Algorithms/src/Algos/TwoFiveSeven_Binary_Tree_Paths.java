package Algos;

import java.util.ArrayList;
import java.util.List;

public class TwoFiveSeven_Binary_Tree_Paths {
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) {
            searchBT(root, "", answer);
        }
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }

        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", answer);
        }

        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", answer);
        }
    }

//    BFS - Queue
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> list=new ArrayList<String>();
//        Queue<TreeNode> qNode=new LinkedList<TreeNode>();
//        Queue<String> qStr=new LinkedList<String>();
//
//        if (root==null) return list;
//        qNode.add(root);
//        qStr.add("");
//        while(!qNode.isEmpty()) {
//            TreeNode curNode=qNode.remove();
//            String curStr=qStr.remove();
//
//            if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
//            if (curNode.left!=null) {
//                qNode.add(curNode.left);
//                qStr.add(curStr+curNode.val+"->");
//            }
//            if (curNode.right!=null) {
//                qNode.add(curNode.right);
//                qStr.add(curStr+curNode.val+"->");
//            }
//        }
//        return list;
//    }

}
