package Algos;

import java.util.Arrays;

public class OneSix_3Sums_Closet {


    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

//        int diff = Integer.MAX_VALUE;
        int ret = nums[0] + nums[1] + nums[2];

        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {// skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == target) {
                    return target;
                } else {
//                    if (diff > Math.abs(sum - target)) {
//                        ret = sum;
//                        diff = Math.abs(sum - target);
//                    }
                    if (Math.abs(ret - target) > Math.abs(sum - target)) {
                        ret = sum;
//                        diff = Math.abs(sum - target);
                    }
                    if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        return ret;
    }
}
