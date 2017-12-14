package Algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OneSixSeven_Two_Sum_II_Input_array_is_sorted {


    public static void main(String[] args){
        int [] a = {2,7,11,15};
        int [] b = twoSum(a, 9);
        System.out.println(Arrays.toString(b));
    }

    public static int[] twoSum(int[] numbers, int target) {

        if(numbers == null || numbers.length ==0){
            return null;
        }
        // hashmap.
//        int ret [] = new int[2];
//        Map<Integer,Integer> mp = new HashMap<>();
//        int diff;
//        for(int i = 0; i < numbers.length; i++){
//            diff = target - numbers[i];
//            if(mp.containsKey(numbers[i])){
//                ret[0] = mp.get(numbers[i])+1;
//                ret[1] = i+1;
//                return ret;
//            }else{
//                mp.put(diff,i);
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");

        // binary search
//        int ret [] = new int[2];
//        for(int i = 0; i < numbers.length-1; i ++){
//            int left = i+1;
//            int right = numbers.length-1;
//            int diff = target - numbers[i];
//            while(left <= right) {
//               int mid = left + (right - left) / 2;
//                if (numbers[mid] == diff) {
//                    return new int[]{i + 1, mid+1};
//                }else if(numbers[mid] > diff){
//                    right = mid-1;
//                }else{
//                    left = mid+1;
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");

        // two pointers
        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            if(numbers[left]+numbers[right] > target){
                right--;
            }else if(numbers[left]+numbers[right] < target){
                left++;
            }else{
                return new int[]{++left,++right};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
