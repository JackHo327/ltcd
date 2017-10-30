package Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoTwoNine_Majority_Element_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time complexity: O(n)
	// space complexity: O(1)
	public List<Integer> majorityElement(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}

		if (nums.length == 1) {
			return Arrays.asList(nums[0]);
		}

		int length = nums.length;
		List<Integer> arrList = new ArrayList<>();

		// boyer-moore majority vote algorithm
		int num1, num2;
		num1 = num2 = nums[0];
		int counter1, counter2;
		counter1 = counter2 = 0;

		for (int i = 0; i < length; i++) {
			if (num1 == nums[i]) {
				counter1++;
			} else if (num2 == nums[i]) {
				counter2++;
			} else if (counter1 == 0) {
				num1 = nums[i];
				counter1 = 1;
			} else if (counter2 == 0) {
				num2 = nums[i];
				counter2 = 1;
			} else {
				counter1--;
				counter2--;
			}
		}

		counter1 = 0;
		counter2 = 0;

		for (int i = 0; i < length; i++) {
			if (nums[i] == num1) {
				counter1++;
			} else if (nums[i] == num2) {
				counter2++;
			}
		}

		if (counter1 > (length / 3)) {
			arrList.add(num1);
		}

		if (counter2 > (length / 3)) {
			arrList.add(num2);
		}

		return arrList;
	}

}
