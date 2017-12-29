package Algos;

import java.util.List;

public class SixTwoFour_Maximum_Distance_in_Arrays {

    public int maxDistance(List<List<Integer>> arrays) {

        if (arrays.size() == 2) {
            return Math.max(Math.abs(arrays.get(0).get(0) - arrays.get(1).get(arrays.get(1).size() - 1)), Math.abs(arrays.get(1).get(0) - arrays.get(0).get(arrays.get(0).size() - 1)));
        }

        int min = Integer.MAX_VALUE;
        int secMin = min;
        int max = Integer.MIN_VALUE;
        int secMax = max;
        int minIndex = 0;
//        int secMinIndex = 0;
        int maxIndex = 0;
//        int secMaxIndex = 0;

        for (int i = 0; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

            if (min >= currMin) {
                secMin = min;
//                secMinIndex = i;
                min = currMin;
                minIndex = i;
            }

            if (secMin > currMin && currMin != min) {
                secMin = currMin;
//                secMinIndex = i;
            }

            if (max <= currMax) {
                secMax = max;
//                secMaxIndex = i;
                max = currMax;
                maxIndex = i;
            }

            if (secMax < currMax && currMax != max) {
                secMax = currMax;
//                secMaxIndex = i;
            }
        }

        if (minIndex == maxIndex) {
            return Math.max(Math.abs(max - secMin), Math.abs(secMax - min));
        }

        return max - min;


        // A clear version
//        int maxDist = Integer.MIN_VALUE;
//        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
//        for (int i = 1; i < arrays.size(); i++) {
//            int currMin = arrays.get(i).get(0);
//            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
//            maxDist = Math.max(maxDist, Math.max(currMax - min, max - currMin));
//            max = Math.max(max, currMax);
//            min = Math.min(min, currMin);
//        }
//        return maxDist;

    }

}
