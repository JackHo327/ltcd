package Algos;

import java.util.Stack;

public class FourFourFive_Addd_Two_Numbers_II {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode node = new ListNode(0);
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) sum += stack1.pop();
            if (!stack2.empty()) sum += stack2.pop();
            node.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = node;
            node = head;
            sum = sum / 10;
        }

        return node.val == 0 ? node.next : node;
    }
}
