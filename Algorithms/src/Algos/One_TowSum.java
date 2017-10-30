package Algos;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

public class One_TowSum {

	public int[] twoSum(int[] nums, int target) {
		// int[] rt = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int k = i + 1; k < nums.length; k++) {
				if (nums[i] + nums[k] == target) {
					// rt[0] = i;
					// rt[1] = k;
					// break;
					return new int[] { i, k };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	// Suggested Answer 1: Brute Force
	// public int[] twoSum(int[] nums, int target) {
	// for (int i = 0; i < nums.length; i++) {
	// for (int j = i + 1; j < nums.length; j++) {
	// if (nums[j] == target - nums[i]) {
	// return new int[] { i, j };
	// }
	// }
	// }
	// throw new IllegalArgumentException("No two sum solution");
	// }
	// Complexity Analysis: Two-pass Hash Table
	// Time complexity : O(n^2).
	// For each element, we try to find its complement by looping through the
	// rest of array which takes O(n)time.
	// Therefore, the time complexity is O(n^2).
	// Space complexity : O(1)O(1).

	// Suggested Answer 2:
	// public int[] twoSum(int[] nums, int target) {
	// Map<Integer, Integer> map = new HashMap<>();
	// for (int i = 0; i < nums.length; i++) {
	// map.put(nums[i], i); // 鈥淵ou may assume that each input would have
	// exactly one solution鈥�, so the sum is unique and it can be key
	// }
	// for (int i = 0; i < nums.length; i++) {
	// int complement = target - nums[i];
	// if (map.containsKey(complement) && map.get(complement) != i) {
	// return new int[] { i, map.get(complement) };
	// }
	// throw new IllegalArgumentException("No two sum solution");
	// }

	// Complexity Analysis:
	// Time complexity : O(n).
	// We traverse the list containing n elements exactly twice.
	// Since the hash table reduces the look up time to O(1), the time
	// complexity is O(n).
	// Space complexity : O(n). - use space to get more time efficient
	// The extra space required depends on the number of items stored in the
	// hash table, which stores exactly n elements.

	// Suggested Answer 3: One-pass Hash Table
	// public int[] twoSum(int[] nums, int target) {
	// Map<Integer, Integer> map = new HashMap<>();
	// for (int i = 0; i < nums.length; i++) {
	// int complement = target - nums[i];
	// if (map.containsKey(complement)) {
	// return new int[] { map.get(complement), i };
	// }
	// map.put(nums[i], i);
	// }
	// throw new IllegalArgumentException("No two sum solution");
	// }

	// Complexity Analysis:
	// Time complexity : O(n).
	// We traverse the list containing n elements only once.
	// Each look up in the table costs only O(1) time.
	// Space complexity : O(n).
	// The extra space required depends on the number of items stored in the
	// hash table, which stores at most n elements.

}
