package Algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeFourNine_IntersectioN_Of_Two_Arrays {


    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] intersection_good_design_logic(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        int max = nums1[0], min = nums1[0];

        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] > max) max = nums1[i];
            else if (nums1[i] < min) min = nums1[i];
        }
        boolean[] bucket = new boolean[max - min + 1];

        for (int num : nums1) bucket[num - min] = true;

        for (int num : nums2) {
            if (num >= min && num <= max) {
                if (bucket[num - min]) {
                    res.add(num);
                    bucket[num - min] = false;
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    // Time complexitu: O(n)
    // Space complexity: O(n)
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Set<Integer> mp = new HashSet<>();

        for (int i : nums1) {
            if (!mp.contains(i)) {
                mp.add(i);
            }
        }

        Set<Integer> mp2 = new HashSet<>();

        for (int i : nums2) {
            if (mp.contains(i)) {
                mp2.add(i);
            }
        }

        int[] ret = new int[mp2.size()];

        int i = 0;

        for (Integer k : mp2) {
            ret[i++] = k;
        }

        return ret;

//         Time Complexity: O(n^2)
//         Space Complexity: O(n)
//         ArrayList<Integer> a = new ArrayList<>();
//         for(int i = 0 ; i < nums1.length; i++){
//             for(int k = 0; k < nums2.length; k++){
//                 if(a.contains(nums1[i])){
//                     break;
//                 }else{
//                     if(nums1[i] == nums2[k]){
//                         a.add(nums1[i]);
//                         break;
//                     }
//                 }
//             }
//         }

//         int [] b = new int[a.size()];

//         for(int i = 0; i < a.size(); i++){
//             b[i] = a.get(i);
//         }

//         return b;
    }
}
