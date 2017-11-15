package Algos;

import java.util.ArrayList;
import java.util.List;

public class OneOneEight_Pascals_Triangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if(numRows <= 0){
            return list;
        }

        for(int i = 0; i < numRows; i++){
            List<Integer> subList = new ArrayList<>();
            subList.add(1);

            // if the no. row > 2, then the centered numbers are come from the neighboured numbers in the last row
            for(int k = 1; k < i; k++){
                List<Integer> sList = list.get(i-1);
                subList.add(sList.get(k-1)+sList.get(k));
            }

            // if the row is not the 1st row, then every row should ended by 1
            if(i!=0){
                subList.add(1);
            }

            list.add(subList);
        }

        return list;

    }
}
