package Top50FaceBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourNine_Group_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0 || strs == null) {
			return new ArrayList<List<String>>();
		} else {
			HashMap<String, ArrayList<String>> mp = new HashMap<>();

			for (int i = 0; i < strs.length; i++) {
				char[] chars = strs[i].toCharArray();
				Arrays.sort(chars);
				String s = new String(chars);
				if (mp.containsKey(s)) {
					// ArrayList <String> tmp = mp.get(s);
					// tmp.add(strs[i]);
					// mp.put(s,tmp);
					mp.get(s).add(strs[i]);
				} else {
					mp.put(s, new ArrayList<String>(Arrays.asList(strs[i])));
				}
			}

			List<List<String>> lst = new ArrayList<List<String>>(mp.values());
			return lst;
		}
	}
}
