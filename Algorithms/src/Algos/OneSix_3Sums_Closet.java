package Algos;

import java.util.Arrays;

public class OneSix_3Sums_Closet {
    
    public int threeSumClosest(int[] nums, int target) {

        // sort the array - then could escape duplicated ones.
        Arrays.sort(nums);

        // create a tmp returned value -- and this is the MIN sum in the nums.
        int ret = nums[0] + nums[1] + nums[2];

        for (int i = 0; i + 2 < nums.length; i++) {
            // skip same result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                // if the sum is the target, then return target.
                if (sum == target) {
                    return target;
                } else {
                    // if the sum is not the target,
                    // then check which one is closer to target
                    // between ret and the current sum.
                    if (Math.abs(ret - target) > Math.abs(sum - target)) {
                        ret = sum;
                    }
                    // if sum is latger than target, then shrink the right bound
                    if (sum > target) {
                        k--;
                    } else {
                        // else then enlarge the left bound.
                        j++;
                    }
                }
            }
        }

        return ret;
    }
}
