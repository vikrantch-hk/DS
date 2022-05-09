package geeks.competetive.programs;

// http://www.geeksforgeeks.org/find-number-of-islands/
public class CountIslands {

	/*
	 * Given a boolean 2D matrix, find the number of islands. A group of
	 * connected 1s forms an island. For example, the below matrix contains 5
	 * islands
	 * 
	 * Input : mat[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0,
	 * 0, 0, 0, 0}, {1, 0, 1, 0, 1} Output : 5
	 */
	// Time complexity: O(ROW x COL)
	public static int countIslands(int a[][]) {
		int count = 0;
		boolean[][] visited = new boolean[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1 && !visited[i][j]) {
					// If a cell with
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					dfs(a, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int[][] a, int i, int j, boolean[][] visited) {
		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int[] tempRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] tempCol = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[i][j] = true;

		for (int k = 0; k < 8; k++) {
			if (isSafe(a, i + tempRow[k], j + tempCol[k], visited))
				dfs(a, i + tempRow[k], j + tempCol[k], visited);
		}
	}

	private static boolean isSafe(int[][] a, int i, int j, boolean[][] visited) {
		return (i >= 0 && i < a.length && j >= 0 && j < a[0].length && (a[i][j] == 1 && !visited[i][j]));

	}

	public static void main(String[] args) {
		int a[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };

		System.out.println("Number of islands is: " + countIslands(a));

	}

}
