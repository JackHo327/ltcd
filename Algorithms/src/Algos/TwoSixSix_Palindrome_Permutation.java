package Algos;

import java.util.HashMap;
import java.util.Map;

public class TwoSixSix_Palindrome_Permutation {

    public boolean canPermutePalindrome(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        // return canBePalindrome(s, s.length()%2 == 0);
        return canBePalindrome(s.length() % 2 == 0, s);
    }

    // HashMap tc: O(n) sc: O(n)
    private boolean canBePalindrome(boolean even, String s) {
        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        int counter = 0;
        // if the length of string is even, then to be a palidrome, the frequencies of chars in the string must also be even
        // if ................ is not even, then ................., it can let one and the only one char has odd frequency
        for (Integer v : mp.values()) {
            if (even) {
                if (v % 2 != 0) {
                    return false;
                }
            } else {
                if (v % 2 != 0) {
                    counter++;
                }
                if (counter > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    // Hash the characters/unicodes tc: O(n) sc:O(1)
    // However, what if the number of unicode is far more than 256 or unpredictable, then it will be less efficient
    private boolean canBePalindrome(String s, boolean even) {

        int counter = 0;
        int[] strs = new int[256];

        for (int i = 0; i < s.length(); i++) {
            strs[s.charAt(i)]++;
        }

        // if the length of string is even, then to be a palidrome, the frequencies of chars in the string must also be even
        // if ................ is not even, then ................., it can let one and the only one char has odd frequency
        for (int k = 0; k < 256; k++) {

            if (even) {
                if (strs[k] % 2 != 0) {
                    return false;
                }
            } else {
                if (strs[k] % 2 != 0) {
                    counter++;
                }
                if (counter > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
