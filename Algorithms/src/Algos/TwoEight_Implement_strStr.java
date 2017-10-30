package Algos;

public class TwoEight_Implement_strStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("", "bcd"));

		System.out.println(strStr2("abc", "bc"));

		System.out.println(strStr3("", ""));
	}

	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return -1;
		} else {
			return haystack.indexOf(needle);
		}
	}

	// Time Complexity = O(n*m) n and m are the length of the string and the
	// searching pattern
	// Space Complexity = O(1)

	public static int strStr2(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return -1;
		} else {
			int l2 = needle.length();

			int diff = haystack.length() - l2;

			for (int i = 0; i <= diff; i++) {
				if (haystack.substring(i, i + l2).equals(needle)) {
					return i;
				}
			}
			return -1;
		}
	}

	// Time Complexity: O(n)
	// Space Complexity: O(1)

	public static int strStr3(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return -1;
		} else {
			for (int i = 0;; i++) {
				for (int t = 0;; t++) {

					if (t == needle.length()) {
						return i;
					}

					if (t + i == haystack.length()) {
						return -1;
					}

					// cannot be execute ahead of the other two if(), since if
					// the string is "", then "".charAt() will throw exceptions
					if (needle.charAt(t) != haystack.charAt(i + t)) {
						break;
					}
				}
			}
		}
	}

	// Time Complexity: O(n)
	// Space Complexity: O(1)
}
