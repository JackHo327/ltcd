package Algos;

public class TwoFourSix_Strobogrammatic_Number {

    public boolean isStrobogrammatic(String num) {
        // Using HashMap
//        Map<Character, Character> map = new HashMap<Character, Character>();
//        map.put('6', '9');
//        map.put('9', '6');
//        map.put('0', '0');
//        map.put('1', '1');
//        map.put('8', '8');
//
//        int l = 0, r = num.length() - 1;
//        while (l <= r) {
//            if (!map.containsKey(num.charAt(l))) return false;
//            if (map.get(num.charAt(l)) != num.charAt(r))
//                return false;
//            l++;
//            r--;
//        }

        // Using 'two pointers'
        if (num == null || num.length() == 0) {
            return true;
        }
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!check(num.charAt(i), num.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    private boolean check(char a, char b) {
        if ((a == '6' && b == '9') || (a == '1' && b == '1') || (a == '8' && b == '8') || (a == '9' && b == '6') || (a == '0' && b == '0')) {
            return true;
        }
        return false;
    }
}
