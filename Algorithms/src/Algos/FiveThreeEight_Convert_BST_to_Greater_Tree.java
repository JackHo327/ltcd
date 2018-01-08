package Algos;

public class FiveThreeEight_Convert_BST_to_Greater_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // a simple recursion
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }

    // another simple recursion
//    int sum = 0;
//    private TreeNode convertBST(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//
//        postOrder(root);
//
//        return root;
//    }
//
//    private void postOrder(TreeNode root){
//        if(root == null){
//            return;
//        }
//
//        postOrder(root.right);
//        sum+=root.val;
//        root.val=sum;
//        postOrder(root.left);
//    }


    // a simple iteration
//    public TreeNode convertBST(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//
//        // using stack and no member field of this class
//        int sum = 0;
//        Stack <TreeNode> stack = new Stack<>();
//
//        TreeNode node = root;
//
//        while(!stack.isEmpty() || node!=null){
//
//            while(node!=null){
//                stack.push(node);
//                node = node.right;
//            }
//
//            node = stack.pop();
//            sum+=node.val;
//            node.val = sum;
//
//            node = node.left;
//
//        }
//
//        return root;
//    }

    // Reversed Morris Inorder Traversal
    /* Get the node with the smallest value greater than this one. */
//    private TreeNode getSuccessor(TreeNode node) {
//        TreeNode succ = node.right;
//        while (succ.left != null && succ.left != node) {
//            succ = succ.left;
//        }
//        return succ;
//    }
//
//    public TreeNode convertBST(TreeNode root) {
//        int sum = 0;
//        TreeNode node = root;
//
//        while (node != null) {
//            /*
//             * If there is no right subtree, then we can visit this node and
//             * continue traversing left.
//             */
//            if (node.right == null) {
//                sum += node.val;
//                node.val = sum;
//                node = node.left;
//            }
//            /*
//             * If there is a right subtree, then there is at least one node that
//             * has a greater value than the current one. therefore, we must
//             * traverse that subtree first.
//             */
//            else {
//                TreeNode succ = getSuccessor(node);
//                /*
//                 * If the left subtree is null, then we have never been here before.
//                 */
//                if (succ.left == null) {
//                    succ.left = node;
//                    node = node.right;
//                }
//                /*
//                 * If there is a left subtree, it is a link that we created on a
//                 * previous pass, so we should unlink it and visit this node.
//                 */
//                else {
//                    succ.left = null;
//                    sum += node.val;
//                    node.val = sum;
//                    node = node.left;
//                }
//            }
//        }
//
//        return root;
//    }

}
