package Algos;

import java.util.Arrays;

public class TwoFiveNine_3Sum_Smaller {

    // this function accpets an int array and a target number,
    // and wil lreturn the number of combos whose sum is smaller than that target number.
    // time complexity: O (n^2)
    // space complexity: O (1)
    public int threeSumSmaller(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        // sort the array.
        Arrays.sort(nums);
        // initialize a counter.
        int counter = 0;
        // loop the array.
        for (int i = 0; i < nums.length - 2; i++) {
            // set two pointers:
            // one is the left bound and the other is the right bound.
            int j = i + 1;
            int k = nums.length - 1;
            // when the left is smaller than the right bound.
            // doing the sub-loop:
            // add numbers up and check whether they are smaller than target.
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // if the sum is larger or equal to the target,
                //then shrink the right bound to make the sub-array smaller.
                if (sum >= target) {
                    k--;
                } else {
                    // if the sum is smaller than the target,
                    // then it means all the combos in this range:
                    // ([i]+ [j,k]) can be smaller than target.
                    // then this number can be calculated by k-j,
                    // e.g.
                    // [-2, 0, 1, 3] target 2
                    // when i = 0 --> nums[0] = -2
                    // when j = 1, k = 3, then nums[0]+nums[1]+nums[3] = 1 < 2
                    // so for i = 0, there are two combos: [-2,0,1] and [-2,0,3].
                    counter += k - j;
                    j++;
                }
            }
        }

        return counter;
    }
}
