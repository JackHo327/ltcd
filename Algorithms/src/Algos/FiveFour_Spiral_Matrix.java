package Algos;

import java.util.ArrayList;
import java.util.List;

public class FiveFour_Spiral_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time complexity: O(n)
	// space complexity: O(n)
	public List<Integer> spiralOrder(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> ret = new ArrayList<Integer>();

		int rows = matrix.length;
		int cols = matrix[0].length;

		int r = 0;
		int c = 0;

		while (r < rows && c < cols) {

			// move to right
			for (int i = c; i < cols; i++) {
				ret.add(matrix[r][i]);
			}

			r++;

			// move down
			for (int i = r; i < rows; i++) {
				ret.add(matrix[i][cols - 1]);
			}

			cols--;

			// move left
			if (r < rows) {
				for (int i = cols - 1; i >= c; i--) {
					ret.add(matrix[rows - 1][i]);
				}
			}

			rows--;

			// move up
			if (c < cols) {
				for (int i = rows - 1; i >= r; i--) {
					ret.add(matrix[i][c]);
				}
			}

			c++;

		}

		return ret;

	}
}
