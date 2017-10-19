package Top50FaceBook;

import java.util.Stack;

public class TwoZero_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid(")("));

	}

	public static boolean isValid(String s) {

		int lenIndex = s.length() - 1;
		if (s == null || s.length() % 2 != 0 || s.charAt(lenIndex) == '(' || s.charAt(lenIndex) == '['
		                || s.charAt(lenIndex) == '{') {
			return false;
		} else {
			Stack<Character> charStack = new Stack<Character>();

			for (char c : s.toCharArray()) {
				if (c == '(')
					charStack.push(')');
				else if (c == '[')
					charStack.push(']');
				else if (c == '{')
					charStack.push('}');
				else if (charStack.isEmpty() || charStack.pop() != c) {
					return false;
				}
			}

			return true;
		}
	}

	// Time Complexity: O(n)
	// Space Complexity: O(n)

	// another stack way
	public boolean isValid2(String s) {
		Stack<Integer> p = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			int q = "(){}[]".indexOf(s.substring(i, i + 1));
			if (q % 2 == 1) {
				if (p.isEmpty() || p.pop() != q - 1)
					return false;
			} else
				p.push(q);
		}
		return p.isEmpty();
	}

	// another stack
	public boolean isValid3(String s) {
		char[] stack = new char[s.length()];
		int head = 0;
		for (char c : s.toCharArray()) {
			switch (c) {
				case '{':
				case '[':
				case '(':
					stack[head++] = c;
					break;
				case '}':
					if (head == 0 || stack[--head] != '{')
						return false;
					break;
				case ')':
					if (head == 0 || stack[--head] != '(')
						return false;
					break;
				case ']':
					if (head == 0 || stack[--head] != '[')
						return false;
					break;
			}
		}
		return head == 0;

	}
}
