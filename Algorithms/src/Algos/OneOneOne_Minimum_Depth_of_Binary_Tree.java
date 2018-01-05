package Algos;


public class OneOneOne_Minimum_Depth_of_Binary_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int height = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }


        // DFS
        inorder(root, 1);
        // preorder(root,1);
        // postorder(root,1);
        return height;
//        BFS
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int height = 0;
//
//        while(!queue.isEmpty()){
//            height++;
//            Queue <TreeNode> tmp = new LinkedList<>();
//            // add/clear the whole row into queue
//            while(!queue.isEmpty()){
//                TreeNode node = queue.poll();
//                if(node.left == null && node.right == null){
//                    return height;
//                }
//                if(node.left!=null){
//                    tmp.offer(node.left);
//                }
//                if(node.right!=null){
//                    tmp.offer(node.right);
//                }
//            }
//            queue = tmp;
//        }
//        return height;

//        Another simpler way:
//        if(root == null) return 0;
//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    // inorder
    private void inorder(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (root.left != null)
            inorder(root.left, cur + 1);

        if (root.left == null && root.right == null) {
            height = Math.min(height, cur);
        }

        if (root.right != null)
            inorder(root.right, cur + 1);
    }

    // preorder
    private void preorder(TreeNode root, int cur) {
        if (root == null) {
            return;
        }


        if (root.left == null && root.right == null) {
            height = Math.min(height, cur);
        }

        if (root.left != null)
            inorder(root.left, cur + 1);

        if (root.right != null)
            inorder(root.right, cur + 1);
    }

    // postorder
    private void postorder(TreeNode root, int cur) {
        if (root == null) {
            return;
        }

        if (root.left != null)
            inorder(root.left, cur + 1);

        if (root.right != null)
            inorder(root.right, cur + 1);

        if (root.left == null && root.right == null) {
            height = Math.min(height, cur);
        }
    }

}
