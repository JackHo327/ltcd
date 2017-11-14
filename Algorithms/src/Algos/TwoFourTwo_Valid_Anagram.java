package Algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoFourTwo_Valid_Anagram {

    // Time complexity: O(n)
    // Space Complexity: O(n)
    public boolean isAnagram_Array(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26]; // default value is 0

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int i : alphabet)
            if (i != 0) {
                return false; // every slot must be zero, or it will be fasle
            }

        return true;
    }

    // Time complexity: O(nlogn)
    // Space Complexity: O(n)
    public boolean isAnagram_Sort(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isAnagram_Map(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char tt = s.charAt(i);
            if (mp.containsKey(tt)) {
                int tmp = mp.get(tt) + 1;
                mp.put(tt, tmp);
            } else {
                mp.put(tt, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char tt = t.charAt(i);
            if (mp.containsKey(tt)) {
                int tmp = mp.get(tt) - 1;
                mp.put(tt, tmp);
            } else {
                mp.put(tt, 1);
            }
        }

        for (char k : mp.keySet()) {
            if (mp.get(k) != 0) {
                return false;
            }
        }

        return true;
    }


}
