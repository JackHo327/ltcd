package Algos;

import java.util.HashSet;
import java.util.Set;

public class SixFourFive_Set_Mismatch {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        // Using HashSet
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n + 1)) / 2;
        for (int i : nums) {
            if (set.contains(i)) duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[]{duplicate, (int) sum + duplicate};

        // Using sorting
//        Arrays.sort(nums);
//        int dup = 0;
//        int sum = nums[0];
//        for(int i = 1; i < nums.length; i ++){
//            if(nums[i-1] == nums[i]){
//                dup = nums[i];
//            }
//            sum+=nums[i];
//        }
//        int missing = (1+nums.length)*nums.length/2 - sum + dup;
//        return new int[]{dup,missing};

    }

}
