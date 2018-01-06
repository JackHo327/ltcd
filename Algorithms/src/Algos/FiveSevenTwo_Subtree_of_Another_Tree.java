package Algos;

public class FiveSevenTwo_Subtree_of_Another_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean bol = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        preorder(s, t);
        return bol;
    }

    // preorder traversal
    private void preorder(TreeNode root, TreeNode t) {
        if (root == null) {
            return;
        }

        if (!bol && root.val == t.val) {
            // if(!bol){ -- this line is also ok, but it is not as readable as the above line.
            bol = isSameTree(root, t);
        }

        preorder(root.left, t);
        preorder(root.right, t);
    }


    // judge whether these subtree is equal to a part of the source tree
    private boolean isSameTree(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        } else {
            return false;
        }


//    One more way-- using preorder traversal and string concatenation to do String.indexOf()
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//         String tree1 = preorder(s, true);
//         String tree2 = preorder(t, true);
//         return tree1.indexOf(tree2) >= 0;
//     }
//     public String preorder(TreeNode t, boolean left) {
//         if (t == null) {
//             if (left)
//                 return "lnull";
//             else
//                 return "rnull";
//         }

//         return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
//     }
    }
}
