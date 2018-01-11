package Algos;

import java.util.ArrayList;
import java.util.List;

public class FourFourTwo_Find_All_Duplicates_in_an_Array {

    public static void main(String[] args) {
        findDuplicates(new int[]{4, 3, 2, 7, 4, 3, 2, 7});
    }

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> retList = new ArrayList<Integer>();

        if (nums == null || nums.length == 0) {
            return retList;
        }

//        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
//                System.out.println(k++);
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;

            }
//            System.out.println(Arrays.toString(nums));
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                retList.add(nums[i]);
            }

        }

        return retList;

    }
}
