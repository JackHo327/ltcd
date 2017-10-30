package Algos;

public class OneTwoFive_Valid_Palindrome {

	public static void main(String[] args) {

		long l1 = System.currentTimeMillis();
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("0p"));
		System.out.println(isPalindrome("ab"));
		System.out.println(isPalindrome("a"));
		System.out.println(isPalindrome(""));
		System.out.println(System.currentTimeMillis() - l1);
		System.out.println("+++++++++++++++++++");
		long l2 = System.currentTimeMillis();
		System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome2("race a car"));
		System.out.println(isPalindrome2("0p"));
		System.out.println(isPalindrome2("ab"));
		System.out.println(isPalindrome2("a"));
		System.out.println(isPalindrome2(""));
		System.out.println(System.currentTimeMillis() - l2);
		System.out.println("+++++++++++++++++++");
		long l3 = System.currentTimeMillis();
		System.out.println(isPalindrome3("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome3("race a car"));
		System.out.println(isPalindrome3("0p"));
		System.out.println(isPalindrome3("ab"));
		System.out.println(isPalindrome3("a"));
		System.out.println(isPalindrome3(""));
		System.out.println(System.currentTimeMillis() - l3);

	}

	public static boolean isPalindrome(String s) {

		if (s == null) {
			return false;
		} else {

			char[] small = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();

			if (small.length > 1) {
				int end = small.length - 1;

				for (int i = 0; i < end; i++) {
					if (small[i] != small[end]) {
						return false;
					} else {
						end--;
					}
				}
				return true;
			} else {
				return true;
			}

		}
	}

	// Time Complexity: O(n)
	// Space Complexity: O(n)

	private static final char[] charMap = new char[256];
	static {
		for (int i = 0; i < 10; i++) {
			charMap[i + '0'] = (char) (1 + i); // numeric
		}
		for (int i = 0; i < 26; i++) {
			charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i); // alphabetic,
			                                                       // ignore
			                                                       // cases
		}
	}

	public static boolean isPalindrome2(String s) {
		char[] pChars = s.toCharArray();
		int start = 0, end = pChars.length - 1;
		char cS, cE;
		while (start < end) {
			cS = charMap[pChars[start]];
			cE = charMap[pChars[end]];
			if (cS != 0 && cE != 0) {
				if (cS != cE)
					return false;
				start++;
				end--;
			} else {
				if (cS == 0)
					start++;
				if (cE == 0)
					end--;
			}
		}
		return true;
	}

	// Time Complexity: O(n)
	// Space Complexity: O(n)

	public static boolean isPalindrome3(String s) {

		if (s == null) {
			return false;
		} else {

			s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

			int start = 0;
			int end = s.length() - 1;

			while (start <= end) {
				if (s.charAt(start) != s.charAt(end)) {
					return false;
				}
				start++;
				end--;
			}
			return true;
		}
	}
}
