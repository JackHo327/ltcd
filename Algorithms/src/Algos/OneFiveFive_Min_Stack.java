package Algos;

import java.util.ArrayDeque;
import java.util.Iterator;

public class OneFiveFive_Min_Stack {


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("1: " + minStack.getMin());
        minStack.pop();
        System.out.println("2: " + minStack.top());
        System.out.println("3: " + minStack.getMin());

    }

    static class MinStack {

        /**
         * initialize your data structure here.
         */
        private ArrayDeque<Integer> arrays;
        private int min;

        public MinStack() {
            this.arrays = new ArrayDeque<>();
        }

        public void push(int x) {
            arrays.addFirst(x);
            // update min
            if (arrays.size() == 1) {
                min = arrays.peekFirst();
            } else {
                if (min > x) {
                    min = x;
                }
            }
        }

        public void pop() {
            int tmp = arrays.pollFirst();
            // update min
            if (min == tmp) {
                if (arrays.peekFirst() != null) {
                    min = arrays.peekFirst();
                }
                Iterator<Integer> it = arrays.iterator();
                while (it.hasNext()) {
                    int next = it.next();
                    if (min > next) {
                        min = next;
                    }
                }
            }

        }

        public int top() {
            return arrays.peekFirst();
        }

        public int getMin() {
            // return min -- always constant - O(1)
            return min;
        }

    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
