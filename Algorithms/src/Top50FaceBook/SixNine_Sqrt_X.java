package Top50FaceBook;

public class SixNine_Sqrt_X {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(1));
	}

	// binary search
	public static int mySqrt(int x) {
		if (x == 0) {
			return 0;
		} else {
			int low = 1;
			int high = x;

			int mid;

			while (low < high) {
				mid = low + (high - low) / 2;
				if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
					return mid;
				} else if (mid > x / mid) {
					high = mid; // keep the left part
				} else {
					low = mid + 1; // keep the right part
				}
			}

			return low;
		}
	}
	// Time Complexity: O(logn)
	// Space Complexity: O(1)

	// Newton's method
	public static int mySqrt1(int x) {
		if (x == 0)
			return 0;

		long r = x;

		while (r > x / r) {
			r = (r + x / r) / 2;
		}

		return (int) r;
	}

}
