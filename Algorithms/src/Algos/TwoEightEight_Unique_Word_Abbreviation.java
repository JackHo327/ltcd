package Algos;

import java.util.HashMap;
import java.util.Map;

public class TwoEightEight_Unique_Word_Abbreviation {

    private Map<String, String> mp = new HashMap<>();

    public TwoEightEight_Unique_Word_Abbreviation(String[] dictionary) {

        for (String s : dictionary) {
            String tmpStr = compressStr(s);
            // if the compressed String exists, then flagged the value slot to represent that there are multiple words can be represented by this abbreviation.
            if (mp.containsKey(tmpStr)) {
                if (!mp.get(tmpStr).equals(s)) {
                    mp.put(tmpStr, "");
                }
            } else {
                // if the compressed String does not exist, then directly add this abbreviation and the String into Map.
                mp.put(tmpStr, s);
            }
        }
    }

    private String compressStr(String str) {
        if (str.length() > 2) {
            return str.charAt(0) + String.valueOf(str.length() - 2) + str.charAt(str.length() - 1);
        } else {
            return str;
        }
    }

    public boolean isUnique(String word) {
        String tmp = compressStr(word);
        // if the abbreviation has existed, then return false -- since it is not unique
        // however, if this abbreviation is created by the word itself, then return true -- because there is no other word which can represented by this abbreviation.
        return !mp.containsKey(tmp) || mp.get(tmp).equals(word);
    }

}
/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
