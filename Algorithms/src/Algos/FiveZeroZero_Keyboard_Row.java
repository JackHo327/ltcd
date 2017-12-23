package Algos;

import java.util.ArrayList;
import java.util.List;

public class FiveZeroZero_Keyboard_Row {

    public String[] findWords(String[] words) {

        if (words == null || words.length == 0) {
            return new String[0];
        }

        String s1 = "eiopqrtuwy";
        String s2 = "bcmnvxz";

        List<String> list = new ArrayList<>();

        for (String s : words) {
            String ss = s.toLowerCase();
            int counter = 0;
            for (int i = 0; i < ss.length(); i++) {
                if (s1.indexOf(ss.charAt(i)) != -1) {
                    counter++;
                }
            }
            if (counter != 0 && counter != ss.length()) {
                continue;
            } else if (counter == ss.length()) {
                list.add(s);
            } else {
                if (counter == 0) {
                    for (int i = 0; i < ss.length(); i++) {
                        if (s2.indexOf(ss.charAt(i)) != -1) {
                            counter++;
                        }
                    }
                    if (counter != 0 && counter != ss.length()) {
                        continue;
                    } else {
                        list.add(s);
                    }
                }
            }
        }

        String sss[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sss[i] = list.get(i);
        }

        return sss;
    }
}
