package Top50FaceBook;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//Note:
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.

public class TwoEightThree_Move_Zeroes {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            System.out.println("Inqualified input!");
        }else{
            int s = 0;
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] != 0){
                    nums[s] = nums[i];
                    s ++;
                }
            }
            for(int k = s ; k < nums.length; k ++){
                nums[k] = 0;
            }
            
        }
	}
}

//Suggested Answer
//public void moveZeroes(int[] nums) {
//    if(nums == null || nums.length == 0){
//        System.out.println("Inqualified input!");
//    }else{
//        int s = 0;
//        for(int i = 0; i < nums.length; i ++){
//            if(nums[i] != 0){
//                // int tmp = nums[s];
//                nums[s] = nums[i];
//                // nums[i] = tmp;
//                nums[i] = 0;
//                s ++;
//            }
//        }   
//    }
//}

//Complexity Analysis
//Space Complexity : O(1). 
//Only constant space is used.
//Time Complexity: O(n). 
//However, the total number of operations are optimal. 
//The total operations (array writes) that code does is Number of non-0 elements. 
//This gives us a much better best-case (when most of the elements are 0) complexity than last solution. 
//However, the worst-case (when all elements are non-0) complexity for both the algorithms is same.