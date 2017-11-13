package Algos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoThreeTwo_Implement_Queue_using_Stacks {

    public static void main(String[] args) {

        MyQueueBetterSol obj = new MyQueueBetterSol();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);

        Queue<Integer> q = new LinkedList<>();

        q.offer(-2);
        q.offer(0);
        q.offer(-3);

        while (!q.isEmpty()) {
            System.out.println("peek: " + (obj.peek() == q.peek()));
            System.out.println("pop: " + (obj.pop() == q.poll()));
        }
    }

    static class MyQueue {
        Stack<Integer> stack1 = null;
        Stack<Integer> stack2 = null;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {

            stack2 = new Stack<>();
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            int ret = stack2.pop();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            return ret;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            stack2 = new Stack<>();
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            int ret = stack2.peek();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            return ret;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty();
        }
    }

    // Better/neater version
    static class MyQueueBetterSol {
        Stack<Integer> stack = null;

        /**
         * Initialize your data structure here.
         */
        public MyQueueBetterSol() {
            stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            Stack <Integer> temp = new Stack<>();
            while(!stack.isEmpty()){
                temp.push(stack.pop());
            }
            stack.push(x);
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {

            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
