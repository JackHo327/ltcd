package Algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiveNineNine_Minimum_Index_Sum_of_Two_List {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // store all chars and their frequency into a map
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            mp.put(list1[i], i);
        }
        // generate a list to maintain all satisfied restaurants
        List<String> li = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            // if the restaurant occurs in list1
            if (mp.containsKey(list2[i])) {
                // then figure out the sum of their index
                int sum = mp.get(list2[i]) + i;
                // if the sum is smaller than min
                if (min > sum) {
                    // then clear the whole list
                    min = sum;
                    li.clear();
                    // add the current restaurant into the list
                    li.add(list2[i]);
                    // if the sume is equals to the min
                } else if (min == sum) {
                    // directly add the restaurant into list
                    li.add(list2[i]);
                }
            }
        }
        // using a array to return the answer.
        String[] ret = new String[li.size()];
        for (int i = 0; i < li.size(); i++) {
            ret[i] = li.get(i);
        }
        return ret;
    }

}
