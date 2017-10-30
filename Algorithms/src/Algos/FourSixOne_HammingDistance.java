package Algos;

public class FourSixOne_HammingDistance {

	public static void main(String[] args) {

		System.out.println(hammingDistance(1, 4));

		System.out.println(hammingDistance2(1, 4));

	}

	public static int hammingDistance(int x, int y) {

		// one hack way
		// return Integer.bitCount(x ^ y);

		int tmp = x ^ y;

		String[] tmpStr = Integer.toBinaryString(tmp).split("");

		int counter = 0;

		// calculate how many 1s in the string, the sum is the hamming distance
		// between two numbers
		for (int i = 0; i < tmpStr.length; i++) {
			if (tmpStr[i].equals("1")) {
				counter++;
			}
		}

		return (counter);

	}
	// Time Complexity: O(n)
	// Space Complexity: O(n)

	public static int hammingDistance2(int x, int y) {

		// do ^ to get the number which represents the difference units between
		// x and y
		int tmp = x ^ y;

		int counter = 0;

		for (int i = 0; i < 32; i++) {
			// >> i calculate how many digits can be represented by 2
			// & 1 whther it is 1
			counter += (tmp >> i) & 1;
		}

		return (counter);
	}
	// Time Complexity: O(n)
	// Space Complexity: O(1)
}
