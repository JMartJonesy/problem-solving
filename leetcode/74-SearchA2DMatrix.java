/*
74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int l = 0;
		int r = m * n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int curr = matrix[mid / n][mid % n];
			if (curr == target) {
				return true;
			}

			if (curr < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return false;
	}
}
