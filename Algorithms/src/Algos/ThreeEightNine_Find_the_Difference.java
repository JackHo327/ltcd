package Algos;

public class ThreeEightNine_Find_the_Difference {


    public static void main(String[] args) {

        System.out.println((char) 97);

        System.out.println(findTheDifference("abcde", "abcedf"));

    }

    // tc: O(n+m) ==> n and m are the length of string s and t respectively
    // sc: O(1)
    public static char findTheDifference(String s, String t) {

        if (s == null || t == null) {
            return 0;
        }

        int zero = 0;

        for (char c : s.toCharArray()) {
            zero = zero ^ c;
        }

        for (char c : t.toCharArray()) {
            zero = zero ^ c;
        }

        return (char) zero;
    }
}
