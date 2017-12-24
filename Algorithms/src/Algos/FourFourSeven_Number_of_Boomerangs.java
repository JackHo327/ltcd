package Algos;

import java.util.HashMap;
import java.util.Map;

public class FourFourSeven_Number_of_Boomerangs {

    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points[0].length == 0) {
            return 0;
        }

        int counter = 0;
        Map<Double, Integer> mp = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] main = points[i];
            for (int k = 0; k < points.length; k++) {
                if (k != i) {
                    int[] sub = points[k];
                    double value = Math.pow(main[0] - sub[0], 2) + Math.pow(main[1] - sub[1], 2);
                    if (mp.containsKey(value)) {
                        int tmp = mp.get(value);
                        counter += tmp * 2;
                        mp.put(value, tmp + 1);
                    } else {
                        mp.put(value, 1);
                    }
                }
            }
            mp = new HashMap<>();
        }

        return counter;
    }
}
