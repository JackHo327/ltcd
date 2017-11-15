package Algos;

import java.util.ArrayList;
import java.util.List;

public class OneOneNine_Pascals_Triangle_II {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> listPascal = new ArrayList<>();

        if (rowIndex < 0) {
            return listPascal;
        }

        // create an array list to hold the numbers related to rowIndex
        // when the No.row is greater than 1,
        // the centered number of the triangle is derived from the neighbor numbers of itself in the above row
        // here by using one array list, we try to create iterated values by continuously update the slots in the list

        for (int i = 0; i < rowIndex + 1; i++) {
            listPascal.add(1);
            for (int j = i - 1; j > 0; j--) {
                listPascal.set(j, listPascal.get(j - 1) + listPascal.get(j));
            }
        }

        return listPascal;
    }

}
