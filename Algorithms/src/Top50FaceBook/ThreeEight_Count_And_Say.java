package Top50FaceBook;

import java.util.Random;

public class ThreeEight_Count_And_Say {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(1));
		System.out.println(countAndSay1(4));
		// System.out.println(getCount("111221"));

		Random rnd = new Random();
		int choice = 1 + rnd.nextInt(4);
		System.out.println(choice);
	}

	public static String countAndSay(int n) {

		if (n < 1) {
			return null;
		} else {
			String holder = "1";

			for (int i = 1; i < n; i++) {
				holder = getCount(holder);
			}
			return holder;
		}
	}

	public static String getCount(String s) {

		int count = 1;
		int slow = 0;
		String rt = "";

		for (int i = 1; i < s.length(); i++) {

			if (s.charAt(i) == s.charAt(slow)) {
				count++;

			} else {

				rt = rt + String.valueOf(count) + String.valueOf(s.charAt(slow));
				slow = i;
				count = 1;
			}
		}
		rt = rt + String.valueOf(count) + String.valueOf(s.charAt(slow));
		return rt;
	}

	// Time Complexity: O(n^2)
	// Space Complexity: O(1)

	// recursive way
	public static String countAndSay1(int n) {

		if (n == 1) {
			return "1";
		} else {
			String s = countAndSay1(n - 1);
			int count = 1;
			int slow = 0;
			StringBuilder rt = new StringBuilder();

			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == s.charAt(slow)) {
					count++;
				} else {
					// concate strs
					rt.append(String.valueOf(count)).append(String.valueOf(s.charAt(slow)));
					slow = i;
					count = 1;
				}
			}
			// concate strs
			rt.append(String.valueOf(count)).append(String.valueOf(s.charAt(slow)));
			return rt.toString();
		}
	}

	// Time Complexity: O(n)
	// Space Complexity: O(1)

	// also a good way, but without recursion
	public String countAndSay2(int n) {
		StringBuilder curr = new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;
		for (int i = 1; i < n; i++) {
			prev = curr;
			curr = new StringBuilder();
			count = 1;
			say = prev.charAt(0);

			for (int j = 1, len = prev.length(); j < len; j++) {
				if (prev.charAt(j) != say) {
					curr.append(count).append(say);
					count = 1;
					say = prev.charAt(j);
				} else
					count++;
			}
			curr.append(count).append(say);
		}
		return curr.toString();

	}
}
