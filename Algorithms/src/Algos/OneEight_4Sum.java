package Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneEight_4Sum {
    class Solution {
        // this function takes an int array and a target int as input,
        // will return a list of list<Integer>, which contains the numbers
        // that can be summed up and the sum is equal to the target,
        // time complexity: O (n^3)
        // space complexity: O (1)
        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> list = new ArrayList<>();

            if (nums == null || nums.length < 4) {
                return list;
            }

            // sort the array.
            Arrays.sort(nums);

            int length = nums.length;
            // if the sum of first 4 integers
            // and the sum of the last 4 integers
            // arelarger or smaller than the target respectively,
            // then there is no right combo in this array.
            int min = nums[0] + nums[1] + nums[2] + nums[3];
            int max = nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4];
            if (min > target || max < target) {
                return list;
            }

            // turn the 4 sum into a 3 sum and then turn the 3 sum into a 2 sum.
            for (int i = 0; i < nums.length - 3; i++) {
                // jump over duplicated combo.
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int diff1 = target - nums[i];

                // turn the 4 sum into a 3 sum
                for (int k = i + 1; k < nums.length - 2; k++) {
                    // jump over duplicated combo.
                    if (k > i + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    // little bit tuning to make the algo more quickly.
                    int subMin = nums[k] + nums[k + 1] + nums[k + 2];
                    int subMax = nums[k] + nums[length - 1] + nums[length - 2];
                    if (subMin > diff1) {
                        break;
                    }
                    if (subMax < diff1) {
                        continue;
                    }

                    int j = k + 1;
                    int p = nums.length - 1;
                    int diff2 = diff1 - nums[k];
                    while (j < p) {
                        // turn the 3 sum into a 2 sum.
                        int subSum = nums[j] + nums[p];
                        if (subSum == diff2) {

                            list.add(Arrays.asList(nums[i], nums[k], nums[j], nums[p]));
                            j++;
                            p--;

                            while (j < p && nums[j] == nums[j - 1]) {
                                j++;
                            }
                            while (j < p && nums[p] == nums[p + 1]) {
                                p--;
                            }

                        } else if (subSum > diff2) {
                            p--;
                        } else {
                            j++;
                        }
                    }

                }

            }

            return list;
        }
    }
}
