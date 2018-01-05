package Algos;

import java.util.*;

public class SixFiveFive_Print_Binary_Tree {

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        // private int height = 0;
        private List<List<String>> list = new ArrayList<>();

        public List<List<String>> printTree(TreeNode root) {

            if (root == null) {
                return list;
            }

            // getHeightDFS(root,1);
            // int m = height;
            int m = getHeightBFS(root);
            // int n = 1 << m - 1;
            int n = (int) Math.pow(2, m) - 1;
            String[][] res = new String[m][n];

            for (String[] arr : res) {
                Arrays.fill(arr, "");
            }

            fill(res, root, 0, 0, n);

            for (String[] arr : res) {
                list.add(Arrays.asList(arr));
            }

            return list;
        }

        private void fill(String[][] res, TreeNode root, int index, int left, int right) {
            if (root == null) {
                return;
            }
            res[index][(left + right) / 2] = String.valueOf(root.val);
            fill(res, root.left, index + 1, left, (left + right) / 2);
            fill(res, root.right, index + 1, (left + right + 1) / 2, right);
        }

        // private int getHeightRecur(TreeNode root){
        //     if(root == null) return 0;
        //     return 1+Math.max(getHeightRecur(root.left),getHeightRecur(root.right));
        // }

        public int getHeightBFS(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            int height = 0;
            while (!queue.isEmpty()) {
                height++;
                Queue<TreeNode> temp = new LinkedList();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.remove();
                    if (node.left != null)
                        temp.add(node.left);
                    if (node.right != null)
                        temp.add(node.right);
                }
                queue = temp;
            }
            return height;
        }

//     private void getHeightDFS(TreeNode root, int cur){
//         if(root == null){
//             return;
//         }

//         if(height < cur){
//             height = cur;
//         }
//         getHeight(root.left, cur+1);
//         getHeight(root.right, cur+1);
//     }
    }

}
