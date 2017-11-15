package Algos;

public class OneEightNine_Rotate_Array {

    // Time complexity : O(n). Only one pass is used.
    // Space complexity : O(1). Constant extra space is used.
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // Time complexity: O(n)
    // Space complexityL O(n) (n-1)
    public void rotate_0ms(int[] nums, int k) {

// Here I calculated a modular to represent the direct displacements of each element in the array. Instead to move every element one by one, we can separate them into 2 clusters based on the modular.

// For example:

// For array [1,2,3,4,5,6,7], when k is 3, we could get a modular as 3, because 3 % 7 = 3. Then we separate the array into two clusters: one is [1,2,3,4] and the other is [5,6,7]. Next, we just need to reform/exchange the sequences of these 2 clusters, and the problem will be solved.

// To exchange the positions of these two clusters, I will advocate using System.arraycopy(src, srcpos, dest, destpos, len), since it is native in the Java and its running speed is very fast.

        if (nums == null) return;

        int modular = k % nums.length;

        if (modular == 0) {
            return;
        }

        int[] arr1 = new int[modular];
        System.arraycopy(nums, nums.length - modular, arr1, 0, modular);
        System.arraycopy(nums, 0, nums, modular, nums.length - modular);
        System.arraycopy(arr1, 0, nums, 0, modular);
    }


    public void rotate_1ms(int[] nums, int k) {

        if (nums == null) return;

        int[] nums1 = new int[nums.length];

        System.arraycopy(nums, 0, nums1, 0, nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (k < nums.length) {
                int mod = (i + k) % nums.length;
                if (i < k) {
                    nums[mod] = nums[i];
                } else {
                    nums[mod] = nums1[i];
                }
            } else {
                int mod = (i + k) % nums.length;
                nums[mod] = nums1[i];
            }
        }
    }
}
