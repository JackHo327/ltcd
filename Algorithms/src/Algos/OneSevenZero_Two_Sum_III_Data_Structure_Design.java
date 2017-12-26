package Algos;

import java.util.HashMap;
import java.util.Map;

public class OneSevenZero_Two_Sum_III_Data_Structure_Design {
    Map<Integer, Integer> mp;

    /**
     * Initialize your data structure here.
     */
    public OneSevenZero_Two_Sum_III_Data_Structure_Design() {
        mp = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        mp.put(number, mp.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer i : mp.keySet()) {
            // if the there is only one element, then return false.
            if (mp.keySet().size() == 1 && mp.get(i) == 1) {
                return false;
            }
            int diff = value - i;
            // if mp contains the diff,
            if (mp.containsKey(diff)) {
                // if this diff is also the current element, then continue loop.
                if (i == diff && mp.get(diff) == 1) {
                    continue;
                } else {
                    // if this diff is not the curr element, then return true.
                    return true;
                }
            }
        }
        return false;
    }
}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */