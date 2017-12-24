package Algos;

import java.util.HashMap;
import java.util.Map;

public class TwoNineZero_Word_Pattern {

    public boolean wordPattern(String pattern, String str) {

        if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0) {
            return false;
        }

        String[] strs = str.split("\\s+");

        if (pattern.length() != strs.length) {
            return false;
        }

        Map<Character, String> mp = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (mp.containsKey(pattern.charAt(i))) {
                String val = mp.get(pattern.charAt(i));
                if (!val.equals(strs[i])) {
                    return false;
                }
            } else {
                if (mp.containsValue(strs[i])) {
                    return false;
                }
                mp.put(pattern.charAt(i), strs[i]);
            }
        }

        return true;
    }
}
