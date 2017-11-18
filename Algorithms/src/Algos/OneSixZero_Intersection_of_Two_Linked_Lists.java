package Algos;

public class OneSixZero_Intersection_of_Two_Linked_Lists {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        //
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int diff = Math.abs(lenA - lenB);

        int counter = 0;

        if (lenA > lenB) {

            while (counter < diff) {
                counter++;
                headA = headA.next;
            }
        } else {
            while (counter < diff) {
                counter++;
                headB = headB.next;
            }
        }

        return getCommon(headA, headB);

    }

    public int getLen(ListNode head) {
        int counter = 1;
        while (head.next != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    public ListNode getCommon(ListNode headA, ListNode headB) {
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNode_Without_Len(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }


}
