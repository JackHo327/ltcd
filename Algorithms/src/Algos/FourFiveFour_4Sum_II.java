package Algos;

import java.util.HashMap;
import java.util.Map;

public class FourFiveFour_4Sum_II {
    // this function takes 4 int arrays as input,
    // and will return the number of combos in these 4 arrays
    // the sum of the combo is equal to 0.
    // time complexity: O (n^2)
    // space complexity: O (n^2)
    //-- hashmap stores 2 arrays sums: n^2 is the worst case;
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int len = A.length;
        int counter = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        // store the sums into the map.
        for (int i = 0; i < D.length; i++) {
            for (int k = 0; k < C.length; k++) {
                mp.put(D[i] + C[k], mp.getOrDefault(D[i] + C[k], 0) + 1);
            }
        }

        // add up values in two arrays
        // and test if there is a opposite sum in the map.
        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                int num2 = -(A[a] + B[b]);
                if (mp.containsKey(num2)) {
                    counter += mp.get(num2);
                }
            }
        }

        return counter;
    }
}
