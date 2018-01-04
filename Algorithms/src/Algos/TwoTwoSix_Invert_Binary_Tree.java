package Algos;

public class TwoTwoSix_Invert_Binary_Tree {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // recursion
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;

//         Queue <TreeNode> tNode = new LinkedList<>();
//         tNode.add(root);

//         while(!tNode.isEmpty()){

//             TreeNode curr = tNode.poll();

//             // if the node does not have left and right children
//             // then no need to swap its kids
//             if(curr.left == null && curr.right == null){
//                 continue;
//             }else{
//                 TreeNode temp = curr.left;
//                 curr.left = curr.right;
//                 curr.right = temp;
//                 // if the left kid is null, then no need to add it into the queue
//                 if(curr.left != null){
//                     tNode.add(curr.left);
//                 }
//                 // if the right kid is null, then no need to add it into the queue
//                 if(curr.right != null){
//                     tNode.add(curr.right);
//                 }
//             }
//         }
        // return root;
    }
}
