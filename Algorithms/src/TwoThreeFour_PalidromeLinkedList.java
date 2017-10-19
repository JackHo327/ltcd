// package Top50FaceBook;
//
// import java.util.Stack;
//
/// **
// * Definition for singly-linked list. public class ListNode { int val;
// ListNode
// * next; ListNode(int x) { val = x; } }
// */
// public class TwoThreeFour_PalidromeLinkedList {
// public boolean isPalindrome(ListNode head) {
// ListNode runner = head;
// ListNode curr = head;
// // stack: first in last out
// Stack<Integer> store = new Stack<Integer>();
//
// while (runner != null && runner.next != null) {
// store.push(curr.val);
// curr = curr.next;
// runner = runner.next.next;
// }
//
// if (runner != null) {
// curr = curr.next;
// }
//
// while (curr != null) {
// if (store.pop().intValue() != curr.val) {
// return false;
// }
// curr = curr.next;
// }
//
// return true;
// }
// }
//// Complexity Analysis:
//// Time Complexity: O(n)
//// Space Complexity: O(1)
