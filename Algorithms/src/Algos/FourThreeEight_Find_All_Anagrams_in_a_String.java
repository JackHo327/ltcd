package Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourThreeEight_Find_All_Anagrams_in_a_String {
    
    public List<Integer> findAnagrams(String s, String p) {

        if (s == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        int lenP = p.length();
        int lenS = s.length();

        List<Integer> list = new ArrayList<>();

        int[] c1 = new int[256];
        int[] c2 = new int[256];

        for (int i = 0; i < p.length(); i++) {
            c1[p.charAt(i)]++;
            c2[s.charAt(i)]++;
        }

        // sliding window, drop the head and add one more element in tail
        for (int i = lenP; i < lenS; i++) {
            if (Arrays.equals(c1, c2)) {
                list.add(i - lenP);
            }
            c2[s.charAt(i)]++;
            c2[s.charAt(i - lenP)]--;
        }

        // check the last window
        if (Arrays.equals(c1, c2)) {
            list.add(lenS - lenP);
        }

        return list;
    }
}
