package Algos;

public class TwoThreeSeven_Delete_Node_In_A_Linked_List {

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
    // usually, in linked list, if we want to remove a node, we do not really "delete" that node, and we just try to jump over it.
    // however, here since we cannot visit the node before the current one, we can only try to set the value of the current one to be the value of the next one, and also set the next one of the current one to be the next of the next one of the current one.
    // In this way, actually we use the next one to replace the current one.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
