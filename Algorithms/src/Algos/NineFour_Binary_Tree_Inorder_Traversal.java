package Algos;

import java.util.ArrayList;
import java.util.List;

public class NineFour_Binary_Tree_Inorder_Traversal {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        return list;
    }

//     List <Integer> list = new ArrayList<>();
//     public List<Integer> inorderTraversal(TreeNode root) {

//         if(root == null){
//             return list;
//         }

//         inOrder(root);

//         return list;
//     }

//     private void inOrder(TreeNode root){
//         if(root == null){
//             return;
//         }

//         inOrder(root.left);
//         list.add(root.val);
//         inOrder(root.right);
//     }
}
