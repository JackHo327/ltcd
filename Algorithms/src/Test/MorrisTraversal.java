package Test;

public class MorrisTraversal {
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode getPrev(TreeNode node) {
        TreeNode nd = node.left;
        while (nd.right != null && nd.right != node) {
            nd = nd.right;
        }
        return nd;
    }

    public static void inorder(TreeNode root) {

        if (root == null) return;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val);
                curr = curr.right;
            } else {
                TreeNode node = getPrev(curr);

                if (node.right == null) {
                    node.right = curr;
                    curr = curr.left;
                } else {
                    node.right = null;
                    System.out.print(curr.val);
                    curr = curr.right;
                }
            }
        }

    }

    public static void preorder(TreeNode root) {

        if (root == null) return;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val);
                curr = curr.right;
            } else {
                TreeNode node = getPrev(curr);

                if (node.right == null) {
                    node.right = curr;
                    System.out.print(curr.val);
                    curr = curr.left;
                } else {
                    node.right = null;
                    curr = curr.right;
                }
            }
        }

    }


    private static void reverseHelper(TreeNode from, TreeNode to) {
        if (from == to) {
            return;
        }

        TreeNode x = from, y = from.right, z;
        while (true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x.equals(to)) {
                break;
            }
        }
    }

    public static void reverse(TreeNode from, TreeNode to) {

        reverseHelper(from, to);
        TreeNode p = to;
        while (true) {
            System.out.print(p.val);
            if (p == from) {
                break;
            }
            p = p.right;
        }
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode dump = new TreeNode(Integer.MIN_VALUE);

        dump.left = root;

        TreeNode curr = dump;

        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode node = getPrev(curr);

                if (node.right == null) {
                    node.right = curr;
                    curr = curr.left;
                } else {
                    reverse(curr.left, node);
                    node.right = null;
                    curr = curr.right;
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.print("postorder:");
        postorder(n1);
        System.out.println();
        System.out.print("inorder:");
        inorder(n1);
        System.out.println();
        System.out.print("preorder:");
        preorder(n1);
    }
}
