package Algos;

public class FourZeroFour_Sum_of_Left_Leaves {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int sumLeft = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorder(root);
        return sumLeft;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorder(root.left);
            // make sure the next left is a leaf
            if (root.left.left == null && root.left.right == null) {
                sumLeft += root.left.val;
            }
        }

        if (root.right != null) {
            inorder(root.right);
        }
    }


//    another recursion way
//    public int sumOfLeftLeaves(TreeNode root){
//
//        if(root == null){
//            return 0;
//        }
//
//        int sumLeft = 0;
//
//        if(root.left != null){
//            if(root.left.left == null && root.left.right == null){
//                sumLeft+=root.left.val;
//            }else{
//                sumLeft+=sumOfLeftLeaves(root.left);
//            }
//        }
//
//        sumLeft+=sumOfLeftLeaves(root.right);
//
//        return sumLeft;
//    }

//    iteration
//    public int sumOfLeftLeaves(TreeNode root){
//
//        if(root == null){
//            return 0;
//        }
//
//        int sumLeft = 0;
//
//        Stack <TreeNode> stack = new Stack<>();
//
//        stack.push(root);
//
//        while(!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            if(node.left!=null){
//                if(node.left.left == null && node.left.right == null){
//                    sumLeft+=node.left.val;
//                }else{
//                    stack.push(node.left);
//                }
//            }
//
//            if(node.right!=null){
//                if(node.right.left !=null || node.right.right != null){
//                    stack.push(node.right);
//                }
//            }
//        }
//
//
//        return sumLeft;
//    }


}
