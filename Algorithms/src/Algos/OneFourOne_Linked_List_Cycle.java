package Algos;

import java.util.HashSet;
import java.util.Set;

public class OneFourOne_Linked_List_Cycle {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        // use two pointers
        ListNode fast = head;
        ListNode back = head;
        while (fast.next != null && back != null && fast.next.next != null) {

            back = back.next;
            fast = fast.next.next;
            if (back == fast) {
                return true;
            }

        }

        return false;
    }

    public boolean hasCycle_HashTable(ListNode head) {

        if(head==null){
            return false;
        }
        // this can be solved by Hash Tables.
        Set<ListNode> mSet = new HashSet<>();
        while(head != null){
            if(mSet.contains(head)){
                return true;
            }
            mSet.add(head);
            head = head.next;
        }

        return false;
    }


}
