// package Top50FaceBook;
//
/// **
// * Definition for singly-linked list. public class ListNode { int val;
// ListNode
// * next; ListNode(int x) { val = x; } }
// */
//
//// Suggested Answer:
// public class TwoZeroTwo_Reverse_Linked_List {
//
// public ListNode reverseList(ListNode head) {
// ListNode prev = null;
// ListNode curr = head;
// while (curr != null) {
// ListNode nextTemp = curr.next;
// curr.next = prev;
// prev = curr;
// curr = nextTemp;
// }
// return prev;
// }
// }
//// Complexity analysis£º
//// Time complexity : O(n). Assume that n is the list's length, the time
//// complexity is O(n).
//// Space complexity : O(1).
//
//// Suggested Answer:
//// public ListNode reverseList(ListNode head) {
//// if (head == null || head.next == null) return head;
//// ListNode p = reverseList(head.next);
//// head.next.next = head;
//// head.next = null;
//// return p;
//// }
//// Complexity analysis
//// Time complexity : O(n). Assume that n is the list's length, the time
//// complexity is O(n).
//// Space complexity : O(n). The extra space comes from implicit stack space
// due
//// to recursion. The recursion could go up to nn levels deep.