package Algos;

public class TwoZeroFour_Count_Primes {
    public int countPrimes(int n) {

        // default value is false;
        boolean[] prime = new boolean[n];

        int count = 0;
        for (int i = 2; i < n; i++) {
            // if this slot has not been visited.
            if (prime[i] == false) {
                // count add 1
                count++;
                // then, find all the values which can be divided by i and are smaller than n
                for (int j = 2; j * i < n; j++) {
                    prime[j * i] = true;
                }
            }
        }

        return count;
    }

}
