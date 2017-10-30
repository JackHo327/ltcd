package Algos;

import java.util.Arrays;

public class FiveSixOne_Array_Partition_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrayPairSum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Arrays.sort(nums);

		int ret = 0;

		for (int i = 0; i < nums.length - 1; i += 2) {
			ret += nums[i];
			// since the array has been sorted so there is no need to judge the
			// smaller one in a pair
			// ret += Math.min(nums[i], nums[i+1]);
		}

		return ret;
	}

}
