package Algos;

public class SixSix_Plus_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time complexity: O(n)
	// space complexity: O(n)

	public int[] plusOne(int[] digits) {
		if (digits == null) {
			return new int[] {};
		}

		int length = digits.length;

		for (int i = length - 1; i >= 0; i++) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			}

			digits[i] = 0;
		}

		int nums[] = new int[length + 1];
		nums[0] = 1;

		// from source to destination
		System.arraycopy(digits, 0, nums, 1, length);

		return nums;
	}

}
