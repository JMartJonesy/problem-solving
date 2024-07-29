/**
 * 130. Surrounded Regions
 * You are given an m x n matrix board containing letters 'X' and 'O', capture
 * regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the
 * region with 'X' cells and none of the region cells are on the edge of the
 * board.
 * A surrounded region is captured by replacing all 'O's with 'X's in the input
 * matrix board.
 **/

public class SurroundedRegions {
	public void solve(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int r = 0; r < m; ++r) {
			if (board[r][0] == 'O') {
				dfs(board, m, n, r, 0);
			}
			if (board[r][n - 1] == 'O') {
				dfs(board, m, n, r, n - 1);
			}
		}

		for (int c = 0; c < n; ++c) {
			if (board[0][c] == 'O') {
				dfs(board, m, n, 0, c);
			}
			if (board[m - 1][c] == 'O') {
				dfs(board, m, n, m - 1, c);
			}
		}

		for (int r = 0; r < m; ++r) {
			for (int c = 0; c < n; ++c) {
				if (board[r][c] == 'O') {
					board[r][c] = 'X';
				}
			}
		}
	}

	private void dfs(char[][] board, int m, int n, int r, int c) {
		board[r][c] = 'Y';

		if (r - 1 >= 0 && board[r - 1][c] == 'O') {
			dfs(board, m, n, r - 1, c);
		}
		if (r + 1 < m && board[r + 1][c] == 'O') {
			dfs(board, m, n, r + 1, c);
		}
		if (c - 1 >= 0 && board[r][c - 1] == 'O') {
			dfs(board, m, n, r, c - 1);
		}
		if (c + 1 < n && board[r][c + 1] == 'O') {
			dfs(board, m, n, r, c + 1);
		}
	}
}
