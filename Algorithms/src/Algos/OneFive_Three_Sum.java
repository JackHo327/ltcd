package Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneFive_Three_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return new ArrayList<List<Integer>>();
		} else {

			List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(nums);
			for (int i = 0; i + 2 < nums.length; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
					continue;
				}
				int j = i + 1, k = nums.length - 1;
				int target = -nums[i];
				while (j < k) {
					if (nums[j] + nums[k] == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[k]));
						j++;
						k--;
						while (j < k && nums[j] == nums[j - 1])
							j++; // skip same result
						while (j < k && nums[k] == nums[k + 1])
							k--; // skip same result
					} else if (nums[j] + nums[k] > target) {
						k--;
					} else {
						j++;
					}
				}
			}
			return res;

			// List <List<Integer>> ARY = new ArrayList<List<Integer>>();

			// if(nums[0] == 0 && nums[0]==nums[1] && nums[1]==nums[2]){
			// ARY.add(Arrays.asList(0,0,0));
			// return ARY;
			// }

			// HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
			// HashSet<List<Integer>> mySet = new HashSet<>();

			// Arrays.sort(nums);

			// for(int i = 0; i < nums.length; i++){
			// if(nums[i] > 0 ){
			// break;
			// }else{
			// for(int k = i+1; k < nums.length; k++){
			// if(mp.containsKey(-nums[i]-nums[k])){
			// mySet.add(Arrays.asList(nums[i], nums[k], -nums[i]-nums[k]));
			// }else{
			// mp.put(nums[k],k);
			// }
			// }
			// mp = new HashMap<Integer,Integer>();
			// }
			// }

			// ARY = new ArrayList<List<Integer>>(mySet);
			// return ARY;
		}
	}
}
