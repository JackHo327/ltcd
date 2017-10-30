package Algos;

import java.util.Arrays;

public class OneSixNine_Majority_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time complexity: O(nlongn)
	// space complexity: O(1)

	public int majorityElement(int[] nums) {

		if (nums == null) {
			return -1;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int length = nums.length;

		Arrays.sort(nums); // after sorting, then could directly return
		                   // nums[length/2]

		int counter = 1;
		int prev = nums[0];

		for (int i = 1; i < length; i++) {
			if (nums[i] == prev) {
				counter++;
				if (counter > (length / 2)) {
					return nums[i];
				}
			} else {
				prev = nums[i];
				counter = 1;
			}
		}

		throw new IllegalArgumentException("Invalid input array");
	}

	// a better solution
	// time complexity: O(n)
	// space complexity: O(1)

	// public int majorityElement(int[] num) {
	//
	// int major=num[0], count = 1;
	// for(int i=1; i<num.length;i++){
	// if(count==0){
	// count++;
	// major=num[i];
	// }else if(major==num[i]){
	// count++;
	// }else count--;
	//
	// }
	// return major;
	// }
}
