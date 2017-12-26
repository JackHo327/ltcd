package Algos;

import java.util.HashMap;
import java.util.Map;

public class FourZeroNine_Longest_Palindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        // Using unicode array/slots [128]
//        int[] chars = new int[128];
//        for (int i = 0; i < s.length(); i++) {
//            chars[s.charAt(i)]++;
//        }
//        boolean flag = false;
//        int ret = 0;
//        for (int i = 0; i < 128; i++) {
//            if (chars[i] % 2 == 0) {
//                ret += chars[i];
//            } else {
//                flag = true;
//                ret += chars[i] - 1;
//            }
//        }
//        if (flag) {
//            return ret + 1;
//        }
//        return ret;


        // Using unicode slots/arrays [26]
//        int[] lowercase = new int[26];
//        int[] uppercase = new int[26];
//        int res = 0;
//        for (int i = 0; i < s.length(); i++){
//            char temp = s.charAt(i);
//            if (temp >= 97) lowercase[temp-'a']++;
//            else uppercase[temp-'A']++;
//        }
//        for (int i = 0; i < 26; i++){
//            res+=(lowercase[i]/2)*2;
//            res+=(uppercase[i]/2)*2;
//        }
//        return res == s.length() ? res : res+1;

        // Using HashMap
        int len = s.length();
        Map<Character, Integer> mp = formMap(s);
        int ret = 0;
        boolean flag = false;
        for (Integer i : mp.values()) {
            if (i % 2 == 0) {
                ret += i;
            } else {
                flag = true;
                ret += i - 1;
            }
        }
        if (flag) {
            return ret + 1;
        }
        return ret;

        //Using HashSet
//         HashSet<Character> hs = new HashSet<Character>();
//         int count = 0;
//         for(int i=0; i<s.length(); i++){
//             if(hs.contains(s.charAt(i))){
//                 hs.remove(s.charAt(i));
//                 count++;
//             }else{
//                 hs.add(s.charAt(i));
//             }
//         }
//         if(!hs.isEmpty()) return count*2+1;
//         return count*2;
    }

    private Map<Character, Integer> formMap(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        return mp;
    }
}
