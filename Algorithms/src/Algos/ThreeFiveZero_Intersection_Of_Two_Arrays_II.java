package Algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeFiveZero_Intersection_Of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        List<Integer> lii = getList(nums1, nums2);

        int[] ret = new int[lii.size()];

        for (int i = 0; i < lii.size(); i++) {
            ret[i] = lii.get(i);
        }

        return ret;
    }

    private List<Integer> getList(int[] nums1, int[] nums2) {

        Map<Integer, Integer> mp1 = new HashMap<>();

        for (int i : nums1) {
            mp1.put(i, mp1.getOrDefault(i, 0) + 1);
        }

        List<Integer> li = new ArrayList<>();

        for (int i : nums2) {
            if (mp1.containsKey(i) && mp1.get(i) > 0) {
                mp1.put(i, mp1.getOrDefault(i, 0) - 1);
                li.add(i);
            }
        }

        return li;
    }
}
