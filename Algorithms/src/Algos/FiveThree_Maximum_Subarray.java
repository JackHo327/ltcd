package Algos;

public class FiveThree_Maximum_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * algorithm that operates on arrays: it starts at the left end (element
	 * A[1]) and scans through to the right end (element A[n]), keeping track of
	 * the maximum sum subvector seen so far. The maximum is initially A[0].
	 * Suppose we've solved the problem for A[1 .. i - 1]; how can we extend
	 * that to A[1 .. i]? The maximum sum in the first I elements is either the
	 * maximum sum in the first i - 1 elements (which we'll call MaxSoFar), or
	 * it is that of a subvector that ends in position i (which we'll call
	 * MaxEndingHere).
	 */

	public static int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}
}
