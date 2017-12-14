package Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourFourEight_Find_All_Numbers_Disappeared_in_an_Array {

    public static void main(String[] args){
        int [] a = {1,1};
        List <Integer> b = findDisappearedNumbers(a);
        System.out.println(b);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> retList = new ArrayList<Integer>();

        if(nums==null || nums.length == 0){
            return retList;
        }

        for(int i =0; i < nums.length; i++){
            while(nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
               // swap
               int tmp = nums[i];
               nums[i] = nums[tmp-1];
               nums[tmp-1] = tmp;
                System.out.println(i+" "+Arrays.toString(nums));
            }
        }

        for(int i=0; i<nums.length;i++){
            if(nums[i] != i+1){
                retList.add(i+1);
            }
        }

        return retList;
    }

//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        List <Integer> retList = new ArrayList<Integer>();
//
//        if(nums==null || nums.length == 0){
//            return retList;
//        }
//
//        for(int i = 0; i < nums.length; i++){
//            if(nums[Math.abs(nums[i])-1] >= 0){
//                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
//            }
//        }
//
//        for(int i =0; i < nums.length; i++){
//            if(nums[i]>0){
//                retList.add(i+1);
//            }
//        }
//
//        return retList;
//    }
}
