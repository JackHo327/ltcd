package Algos;

public class OneThreeSix_Single_Number {

    public int singleNumber(int[] nums) {

        // tc: O(n)
        // sc: O(1)
        // bit manipulation
        int zero = 0;
        for (int i : nums) {
            zero = zero ^ i;
        }
        return zero;

        // tc: O(n)
        // sc: O(n)
        // hash map
//        Map<Integer, Integer> mp = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
//        }
//        for (Integer i : mp.keySet()) {
//            if (mp.get(i) == 1) {
//                return i;
//            }
//        }
//        return 0;

        // tc: O(nlogn)
        // sc: O(1)
        // sorting
//        Arrays.sort(nums);
//        int b = 0;
//        int f = 1;
//        for( ;f < nums.length; f = f + 2){
//            if(nums[f] != nums[b]){
//                return nums[b];
//            }
//            b = b + 2;
//        }
//        return 0;
    }
}
