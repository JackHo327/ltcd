package Algos;

public class OneOneTwo_Path_Sum {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean bol = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        helper(root, 0, sum);

        return bol;

        // another recursion method
//        sum -= root.val;
//
//        if(root.left == null && root.right == null){
//            if(sum == 0){
//                return true;
//            }else{
//                return false;
//            }
//        }
//
//        boolean left = hasPathSum(root.left, sum);
//        if(left){
//            return left;
//        }
//
//        boolean right = hasPathSum(root.right, sum);
//        if(right){
//            return right;
//        }

//        return false;

    }

    private void helper(TreeNode root, int accu, int sum) {

        if (!bol) {
            if (root.left == null && root.right == null) {
                accu += root.val;
                bol = accu == sum;
//                if (!bol) {
//                    accu -= root.val;
//                }
            }

            if (root.left != null) {
                helper(root.left, accu + root.val, sum);
            }

            if (root.right != null) {
                helper(root.right, accu + root.val, sum);
            }

        }
    }


    // one short method
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null) return false;
//
//        if(root.left == null && root.right == null && sum - root.val == 0) return true;
//
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }
}
