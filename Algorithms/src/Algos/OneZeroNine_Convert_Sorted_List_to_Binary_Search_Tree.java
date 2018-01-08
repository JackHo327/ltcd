package Algos;

public class OneZeroNine_Convert_Sorted_List_to_Binary_Search_Tree {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private ListNode current;

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - size / 2 - 1);
        root.left = left;
        root.right = right;

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        current = head;
        int size = getSize(head);
        return sortedListToBSTHelper(size);
    }

//    using a list to save all listnodes then do recursion
//    this way costs extra O (n) spaces
//    private List<ListNode> list = new ArrayList<>();
//
//    public TreeNode sortedListToBST(ListNode head) {
//
//        if (head == null) {
//            return null;
//        }
//        // put all listnodes into a list - so that they could be visited by index
//        while (head != null) {
//            list.add(head);
//            head = head.next;
//        }
//
//        TreeNode root = getNode(0, list.size() - 1);
//
//        return root;
//    }
//
//    private TreeNode getNode(int start, int end) {
//
//        if (start > end) {
//            return null;
//        }
//
//        int mid = start + (end - start) / 2;
//        TreeNode root = new TreeNode(list.get(mid).val);
//        root.left = getNode(start, mid - 1);
//        root.right = getNode(mid + 1, end);
//
//        return root;
//    }
}
