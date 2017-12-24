package Algos;


import java.util.HashMap;
import java.util.Map;

public class TwoZeroFive_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {

        // s and t have the same length
        if (s == null || t == null) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        // with array
        // tc: O (n)
        // sc: O (len)
//        int[] array = new int[512];
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (array[s.charAt(i)] != array[t.charAt(i) + 256]) {
//                return false;
//            }
//
//            array[s.charAt(i)] = array[t.charAt(i) + 256] = i + 1;
//
//        }


        // with hashMap
        Map<Character, Character> mp = new HashMap<>();
        // use a map to store <c1, c2> pairs
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            // if map containsKey c1
            if (mp.containsKey(cs)) {
                // compare the current c2 and the stored c2
                char tmpCt = mp.get(cs);
                if (tmpCt != ct) {
                    return false;
                }
            } else {
                // if map does not containsKey c1
                // judge whether it containsValue c2
                // if not, then add <c1,c2> pair
                // or return false
                if (!mp.containsValue(ct)) {
                    mp.put(cs, ct);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
