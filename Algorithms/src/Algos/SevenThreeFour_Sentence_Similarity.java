package Algos;

import java.util.HashSet;
import java.util.Set;

public class SevenThreeFour_Sentence_Similarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || pairs == null || words1.length != words2.length) {
            return false;
        }
        if (words1.length == 0 || words2.length == 0) {
            return true;
        }
        Set<String> set = new HashSet<>(40);
        for (int i = 0; i < pairs.length; i++) {
            String s1 = pairs[i][0] + " " + pairs[i][1];
            set.add(s1);
        }
        for (int i = 0; i < words1.length; i++) {
            String s1 = words1[i] + " " + words2[i];
            String s2 = words2[i] + " " + words1[i];
            if (!set.contains(s1) && !set.contains(s2)) {
                if (s1.equals(s2)) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

}
