package Algos;

public class OneZeroOne_Symmetric_Tree {
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null || right == null) {
            return left == right;
        }

        if (left.val == right.val) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }

        return false;
    }

//    iteration methtod
//    public boolean isSymmetric(TreeNode root) {
//         if(root == null){
//             return true;
//         }

//         if(root.left == null && root.right == null){
//             return true;
//         }

//         if(root.left == null || root.right == null){
//             return false;
//         }

//         Deque <TreeNode> d1 = new ArrayDeque<>();
//         Deque <TreeNode> d2 = new ArrayDeque<>();

//         // add the left and right subtrees
//         d1.push(root.left);
//         d2.push(root.right);

//         while(!d1.isEmpty() && !d2.isEmpty()){
//             TreeNode n1 = d1.pop();
//             TreeNode n2 = d2.pop();

//             if(n1.val != n2.val){
//                 return false;
//             }

//             if(n1.left != null){
//                 d1.push(n1.left);
//             }

//             if(n2.right != null){
//                 d2.push(n2.right);
//             }

//             if(d1.size() != d2.size()){
//                 return false;
//             }

//             if(n1.right != null){
//                 d1.push(n1.right);
//             }

//             if(n2.left != null){
//                 d2.push(n2.left);
//             }

//             if(d1.size() != d2.size()){
//                 return false;
//             }
//         }

//         return d1.size() == d2.size();
//     }
}
