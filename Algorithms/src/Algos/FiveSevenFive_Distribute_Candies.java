package Algos;

import java.util.HashSet;
import java.util.Set;

public class FiveSevenFive_Distribute_Candies {


    public int distributeCandies(int[] candies) {
        // tc: O(n)
        // sc: O(n)
        // by using set
        if (candies.length % 2 != 0) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();

        for (int i : candies) {
            set.add(i);
        }

        int len = candies.length / 2;
        return Math.min(set.size(), len);
    }

//    public int distributeCandies(int[] candies) {
//        // tc: O(nlogn)
//        // sc: O(1)
//        // by using sorting
//        if (candies.length % 2 != 0) {
//            return -1;
//        }
//
//        int counter = 1;
//        Arrays.sort(candies);
//        int prev = 0;
//
//        for (int i = 1; i < candies.length && counter <= candies.length / 2; i++) {
//            if (candies[prev++] != candies[i]) {
//                counter++;
//            }
//        }
//
//        return counter;
//    }


}
