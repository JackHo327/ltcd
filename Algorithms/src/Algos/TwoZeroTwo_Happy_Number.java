package Algos;

public class TwoZeroTwo_Happy_Number {
    // sc: O(1)
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        while (n > 6) {
            n = splitAndConquer(n);
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    public int splitAndConquer(int n) {
        String num = String.valueOf(n);
        char[] s = num.toCharArray();
        int ret = 0;
        for (char c : s) {
            ret = ret + Character.getNumericValue(c) * Character.getNumericValue(c);
        }
        return ret;
    }
}
