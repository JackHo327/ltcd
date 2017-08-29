package Top50FaceBook;

public class TwoSix_Remove_Duplicates_from_Sorted_Array {

	// test
	// public static void main(String[] args) {
	// int nums[] = new int[] { 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3 };
	// System.out.println(removeDuplicates(nums));
	// }

	// public static int removeDuplicates(int[] nums) {
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			throw new IllegalArgumentException("Invaliad nums[]");
		} else {
			int s = 0;
			for (int f = 0; f < nums.length; f++) {
				while (f != s && nums[f] != nums[s]) {
					nums[++s] = nums[f];
				}
			}
			return (s + 1);
		}
	}
}

// Complexity Analysis:
// Time Complexity: O(n). Loop the nums[] for n times.
// Space Complexity: O(1). Only need to store one variable-s in the space.

// Suggested Answer
// public int removeDuplicates(int[] nums) {
// if (nums.length == 0) return 0;
// int i = 0;
// for (int j = 1; j < nums.length; j++) {
// if (nums[j] != nums[i]) {
// i++;
// nums[i] = nums[j];
// }
// }
// return i + 1;
// }
// Complexity analysis
// Time complextiy : O(n).
// Assume that n is the length of array. Each of ii and j traverses at most n
// steps.
// Space complexity : O(1)O(1).
