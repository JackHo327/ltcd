package Algos;

import java.util.Arrays;

public class SixOneOne_Valid_Triangle_Number {
    class Solution {
        // this function takes an int array as input,
        // and will return a int as the counter of how many combo can form a valid triangle.
        // the time complexity is O (n^2)
        // the space complexity is O (1)
        public int triangleNumber(int[] nums) {
            int ret = 0;
            if (nums == null || nums.length < 3) {
                return ret;
            }
            // sort the array, then just need to think about whether a + b > c
            // assume (a,b,c) -- a <= b <= after the sorting.
            Arrays.sort(nums);

            int counter = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                // if the nums[i] is 0, then continue looping to the next one.
                if (nums[i] <= 0) {
                    continue;
                }

                int k = i + 2;
                for (int j = i + 1; j < nums.length - 1; j++) {
                    // find the one just larger than the sum of nums[i] and nums[j].
                    while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                        k++;
                    }
                    // k-1 --> minus that redundant one,
                    // which is just larger than the sum of nums[i] and nums[j].
                    counter += (k - 1) - j;
                }
            }

            return counter;
        }
    }
//    private static int binarySearch(int nums[], int l, int r, int x) {
//        while (r >= l && r < nums.length) {
//            int mid = (l + r) / 2;
//            if (nums[mid] >= x)
//                r = mid - 1;
//            else {
//                l = mid + 1;
//            }
//        }
//
//        // find the index of the element which is just larger than the nums[i]+nums[j]
//        return l;
//    }
//
//    public static int triangleNumber(int[] nums) {
//        int count = 0;
//        // sort the array, then just need to think about whether a + b > c
//        // assume (a,b,c) -- a <= b <= after the sorting.
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            int k = i + 2;
//            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
//                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
//                System.out.println(i + " " + j + " " + k);
//                // (k-1) - (j+1) + 1.
//                // k-1 -> minus that redundant one which is just larger than nums[i]+nums[j].
//                count += (k - 1) - j;
//            }
//        }
//        return count;
//    }
}
