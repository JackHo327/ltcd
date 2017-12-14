package Algos;

public class TwoZeroThree_Remove_Linked_List_Elements {
    
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        // head.next = removeElements(head.next,val);

        return head;
    }

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */