package Algos;

public class OneThree_Roman_to_Integer {
	public int romanToInt(String s) {
		int[] nums = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case 'I':
					nums[i] = 1;
					break;
				case 'V':
					nums[i] = 5;
					break;
				case 'X':
					nums[i] = 10;
					break;
				case 'L':
					nums[i] = 50;
					break;
				case 'C':
					nums[i] = 100;
					break;
				case 'D':
					nums[i] = 500;
					break;
				case 'M':
					nums[i] = 1000;
					break;
			}
		}

		int sum = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				sum -= nums[i];
			} else {
				sum += nums[i];
			}
		}
		// add the last one
		return sum + nums[s.length() - 1];
	}
}
// Complexity Analysis:
// Time Complexity: O(n). loop nums[] and s.toCharArray[]
// Space Complexity: O(1). variable 'sum'.
