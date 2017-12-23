package Algos;

public class FourSixThree_Island_Perimeter {

    public int islandPerimeter(int[][] grid) {

        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int t = 0; t < grid[i].length; t++) {
                if (grid[i][t] == 1) {
                    if (t > 0 && grid[i][t - 1] == 1) {
                        ret += 2;
                    } else {
                        ret += 4;
                    }

                    if (i < grid.length - 1 && grid[i + 1][t] == 1) {
                        ret -= 2;
                    }

                }
            }
        }

        return ret;
    }
}
