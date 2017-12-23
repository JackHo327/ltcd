package Test;

public class Tester {

    public static void main(String[] args) {
        System.out.println(isPrime(4));
    }

    private static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        int i = 1;
        int counter = 0;
        while (i <= n) {
            if (n % i++ == 0) {
                counter++;
            }
        }
        if (counter == 2) {
            return true;
        } else {
            return false;
        }
    }
}
