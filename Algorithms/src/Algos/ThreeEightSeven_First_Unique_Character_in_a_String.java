package Algos;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreeEightSeven_First_Unique_Character_in_a_String {

    public int firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }

        // String 1
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }

        // String 2
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }

        // LinkedHashMap
        Map<Character, Integer> mp = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }


        for (Character cc : mp.keySet()) {
            if (mp.get(cc) == 1) {
                return (s.indexOf(cc));
            }
        }
        return -1;


    }

}
