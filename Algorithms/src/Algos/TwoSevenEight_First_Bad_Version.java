package Algos;

public class TwoSevenEight_First_Bad_Version {
	public static void main(String[] args) {

	}

	public int firstBadVersion(int n) {
		if (n == 1) {
			if (isBadVersion(n)) {
				return n;
			}
			return -1;
		} else {
			int start = 1;
			int end = n;
			int mid;
			while (start < end) {
				mid = start + (end - start) / 2;
				if (isBadVersion(mid)) {
					end = mid;
					if (mid == 1 || !isBadVersion(mid - 1)) {
						return mid;
					}
				} else {
					start = mid + 1;
					if (isBadVersion(start)) {
						return start;
					}
				}
			}
			return -1;
		}
	}

	// Time Complexity: O(logn)
	// Space Complexity: O(1)

	// a quicker and clear way
	public int firstBadVersion1(int n) {
		if (n == 1) {
			if (isBadVersion(n)) {
				return n;
			}
			return -1;
		} else {
			int start = 1;
			int end = n;
			int mid;
			while (start < end) {
				mid = start + (end - start) / 2;
				if (isBadVersion(mid)) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			return start;
		}
	}
}
