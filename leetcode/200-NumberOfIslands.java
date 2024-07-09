import java.util.LinkedList;

/**
 * 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 */
public class NumberOfIsland {
	public int numIslands(char[][] grid) {
		int islands = 0;
		for (int r = 0; r < grid.length; ++r) {
			for (int c = 0; c < grid[0].length; ++c) {
				if (grid[r][c] == '1') {
					++islands;
					bfs(grid, r, c);
				}
			}
		}

		return islands;
	}

	private void bfs(char[][] grid, int x, int y) {
		LinkedList<int[]> bfs = new LinkedList<>();

		bfs.add(new int[] { x, y });
		while (!bfs.isEmpty()) {
			int[] top = bfs.poll();
			int topX = top[0];
			int topY = top[1];
			if (grid[topX][topY] == '1') {
				if (isValidNeighbor(grid, topX - 1, topY)) {
					bfs.offer(new int[] { topX - 1, topY });
				}
				if (isValidNeighbor(grid, topX + 1, topY)) {
					bfs.offer(new int[] { topX + 1, topY });
				}
				if (isValidNeighbor(grid, topX, topY - 1)) {
					bfs.offer(new int[] { topX, topY - 1 });
				}
				if (isValidNeighbor(grid, topX, topY + 1)) {
					bfs.offer(new int[] { topX, topY + 1 });
				}
			}

			grid[topX][topY] = 'V';
		}
	}

	private boolean isValidNeighbor(char[][] grid, int x, int y) {
		if (x < 0 || x > grid.length - 1) {
			return false;
		}
		if (y < 0 || y > grid[0].length - 1) {
			return false;
		}
		if (grid[x][y] == 'V') {
			return false;
		}

		return true;
	}
}
