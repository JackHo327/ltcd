package Algos;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class TwoTwoZero_Contains_Duplicate_III {



        // This problem requires to maintain a window of size k of the previous values that can be queried for value ranges. The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result in time complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries can be executed both of time complexity O(log min(n,k)) ==> O(logn) (binary search tree) space complexity O(log min(n,k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Initialize an empty BST set
        //  Loop through the array, for each element xx
        //  Find the smallest element ss in set that is greater than or equal to xx, return true if s - x \leq ts−x≤t
        //  Find the greatest element gg in set that is smaller than or equal to xx, return true if x - g \leq tx−g≤t
        //  Put xx in set
        //  If the size of the set is larger than kk, remove the oldest item.
        //  Return false
        if (nums.length < 2 || k <= 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        int i = 0;
        while (i < nums.length) {
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            if ((floor != null && nums[i] - floor <= t) ||
                    (ceiling != null && ceiling - nums[i] <= t)) {
                return true;
            }
            set.add((long) nums[i++]);

            // keep a k-length window
            if (i > k) {
                set.remove((long) nums[i - k - 1]);
            }
        }
        return false;

    }

    // https://leetcode.com/problems/contains-duplicate-iii/solution/
    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate_Bucket(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the neighbor buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in neighbor buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

}
