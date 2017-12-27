package Algos;

import java.util.HashMap;
import java.util.Map;

public class FiveNineFour_Longest_Harmonious_Subsequence {
    public static int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        for (Integer i : mp.keySet()) {
            if (mp.containsKey(i + 1)) {
                int tmp = mp.get(i) + mp.get(i + 1);
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
