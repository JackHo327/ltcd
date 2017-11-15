package Algos;

public class TwoSixEight_Missing_Number {

    // Time complexity: O(n)
    // Space complexity: O(1)
    // Treat it as a Math problem -- the Missing Value of a sequential numeric set will be (the expected sum - the actual sum).
    // For example, [0,1,3] ==> the expected sum will be (0 + 1 + 2 + 3) = 6, but the actual sum is (0 + 1 + 3) = 4, and so the missing value is 6 - 4 = 2.
    public int missingNumber(int[] nums) {
        // math problem

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int len = nums.length;
        int expectedSum = (0 + len) * (len + 1) / 2;

        return expectedSum - sum;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int missingNumber_XOR(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
