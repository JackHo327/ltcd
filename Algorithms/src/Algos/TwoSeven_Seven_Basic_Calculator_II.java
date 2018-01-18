package Algos;

import java.util.Stack;

public class TwoSeven_Seven_Basic_Calculator_II {
    
    // this function will take a String as input
    // and will return the whole value of this mathematic expression.
    // the time complexity is O (n).
    // the space complexity is O (n).
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // continuously get the current valid number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {
                // remove the invalid addition.
                // specify to the * and / condition.
                if ("*/".indexOf(op) >= 0) {
                    result -= stack.peek();
                }

                // update the stack based on op -- the last operator,
                // currently op is not the c -- the new operator.
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    // update the "first" element in the stack.
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                op = c;
                result += stack.peek();
            } /* else whitespace */
        }
        return result;
    }


}
