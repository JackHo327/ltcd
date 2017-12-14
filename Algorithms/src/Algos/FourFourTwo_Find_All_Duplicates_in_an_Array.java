package Algos;

import java.util.ArrayList;
import java.util.List;

public class FourFourTwo_Find_All_Duplicates_in_an_Array {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> retList = new ArrayList<Integer>();

        if(nums == null|| nums.length == 0){
            return retList;
        }

        for(int i = 0; i < nums.length; i ++){
            while(nums[i] != i+1 && nums[nums[i]-1] != nums[i]){

                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;

            }
        }

        for(int i = 0; i < nums.length; i ++){

            if(nums[i] != i+1){
                retList.add(nums[i]);
            }

        }

        return retList;

    }
}
