package Algos;

import java.util.*;

public class TwoOneSeven_Contains_Duplicate {

    // Given an array of integers, find if the array contains any duplicates.
    // Your function should return true if any value appears at least twice in the array,
    // and it should return false if every element is distinct.

    // time complexity: O(nlogn)
    // space complexity: O(1)
    public boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length == 0){
            return false;
        }

        boolean bol = false;

        // sort the array ascending.
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                bol = true;
                break;
            }
        }

        return bol;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    public boolean containsDuplicate_Hash(int[] nums) {

        if(nums == null || nums.length == 0){
            return false;
        }

        boolean bol = false;

        // HashSet is better
        HashSet<Integer> mySet = new HashSet<Integer>();

        for(int i:nums){
            if(!mySet.add(i)){ // set.add() will return "true" value, if the set did not already contain the specified element.
                bol = true;
                break;
            }
        }
        // Map<Integer, Integer> mp = new HashMap<>();
        // for(int i = 0; i < nums.length-1; i++){
           // if(mp.containsKey(i)){
               // bol = true;
               // break;
           // }else{
               // mp.put(i,1);
           // }
        // }

        return bol;
    }
}
