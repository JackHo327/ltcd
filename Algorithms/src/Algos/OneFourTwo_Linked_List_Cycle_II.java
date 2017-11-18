package Algos;

public class OneFourTwo_Linked_List_Cycle_II {

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {

        if(head==null){
            return null;
        }

        // use two pointers
        ListNode fast = head;
        ListNode back = head;

        while(fast.next != null && back != null && fast.next.next != null){
            back = back.next;
            fast = fast.next.next;
            if(back == fast){
                ListNode back2 = head;
                while(back2 != back){
                    back2 = back2.next;
                    back = back.next;
                }
                return back;
            }
        }

        return null;
    }

}
