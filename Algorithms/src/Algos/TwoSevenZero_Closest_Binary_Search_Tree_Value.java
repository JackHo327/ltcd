package Algos;

public class TwoSevenZero_Closest_Binary_Search_Tree_Value {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int closestValue(TreeNode root, double target) {

        if (root == null) {
            return 0;
        }

        // a cleaner method
//            int ret = root.val;
//            while(root != null){
//                if(Math.abs(target - root.val) < Math.abs(target - ret)){
//                    ret = root.val;
//                }
//                root = root.val > target? root.left: root.right;
//            }


        TreeNode curr = root;
        TreeNode prev = root;
        double diff = Double.MAX_VALUE;
        while (curr != null) {
            double tmp = Math.abs(curr.val - target);
            if (tmp < diff) {
                diff = tmp;
                prev = curr;
            }

            // which means curr.val - target > 0,
            // so it's not reasonable to move right, becuase the diff will be larger
            if (curr.val > target) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return prev.val;
    }

    // tree traversal
//     private double diff = Double.MAX_VALUE;
//     private int close = 0;
//     public int closestValue(TreeNode root, double target) {

//         if(root == null){
//             return 0;
//         }

//         helper(root, target);

//         return close;
//     }

//     private void helper(TreeNode root, double target){

//         if(root.left != null){
//             helper(root.left, target);
//         }

//         double tmp = Math.abs(root.val - target) ;

//         if(tmp < diff){
//             close = root.val;
//             diff = tmp;
//         }

//         if(root.right != null){
//             helper(root.right, target);
//         }
//     }
}
