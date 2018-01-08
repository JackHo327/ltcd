package Algos;

public class SixZeroSix_Construct_String_from_Binary_Tree {
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public String tree2str(TreeNode t) {

//        another simple recursion
//        if (t == null) return "";
//
//        String ret = "" + t.val;
//
//        String left = tree2str(t.left);
//        String right = tree2str(t.right);
//
//        if (left.equals("") && right.equals("")) return ret;
//        if (left.equals("")) return ret + "()(" + right + ")";
//        if (right.equals("")) return ret + "(" + left + ")";
//
//        return ret + "(" + left + ")(" + right + ")";
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        return preorder(t, sb).toString();
    }

    private StringBuilder preorder(TreeNode t, StringBuilder sb) {

        sb.append(t.val);

        if (t.left != null) {
            sb = preorder(t.left, sb.append("("));
            sb.append(")");
        } else {
            if (t.right != null) {
                sb.append("()");
            }
        }

        if (t.right != null) {
            sb = preorder(t.right, sb.append("("));
            sb.append(")");
        }

        return sb;
    }

}
