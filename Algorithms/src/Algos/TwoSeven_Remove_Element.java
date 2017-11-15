package Algos;

import java.util.Arrays;

public class TwoSeven_Remove_Element {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        // [3,2,2,3]
        // 3
        // for [3,2,2,3]
        // set i and b as flags
        // when nums[i] doesnt equal to val
        // nums[b] = nums[i] and b++
        // when nums[i] == val, then b remain the current value
        // in the end return b.
        // b = 0; i = 0
        // when i = 1, num[b] = nums[0] = nums[i] = nums[1] = 2 ==> [2,2,2,3] and b++
        // when i = 2, nums[b] = nums[1] = nums[i] = nums[2] = 2 ==> [2,2,2,3] and b++
        // end then loop return b = 2.
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[b] = nums[i];
                b++;
            }
        }

        return b;

    }

    public int two_point(int[] nums, int val) {
        int i = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == val) {
                nums[i] = nums[r];
                // reduce array size by one
                r--;
            } else {
                i++;
            }
        }

        return r + 1;
    }
}
