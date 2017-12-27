package Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Tester {

    public static void main(String[] args) {
//        System.out.println(1 % 2);
        int[] nums = new int[]{};
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int s = 0;
        int counter = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[s] == 1) {
                counter = i - s + 1;
//                System.out.println(counter);
//                System.out.println(counter);
            } else if (nums[i] - nums[s] > 1) {
//                System.out.println(nums[i] + " " + nums[s]);
                pq.offer(counter);
                counter = 0;
                s = s + 1;
            } else {
                continue;
            }
        }
        pq.offer(counter);
        if (pq.isEmpty()) {
            return counter;
        }
        return pq.peek();
    }

}
