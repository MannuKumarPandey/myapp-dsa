package graph;

public class FloodFillTheColors {

	public static void main(String[] args) {

		int[][] adjMatrix = getUDUWGraphAdjList();

		// given details
		int sr = 2;
		int sc = 0;
		int newColor = 3;

		int ans1[][] = floodFill(adjMatrix, sr, sc, newColor);
		for (int[] res : ans1) {
			for (int hh : res) {
				System.out.print(hh + " ");
			}
			System.out.println();
		}
	}

	private static int[][] floodFill(int[][] adjMatrix, int sr, int sc, int newColor) {

		int ans[][] = adjMatrix;
		int initialColor = adjMatrix[sr][sc];

		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, 1, 0, -1 };

		dfs(sr, sc, ans, adjMatrix, newColor, deltaRow, deltaColumn, initialColor);

		return ans;

	}

	private static void dfs(int row, int column, int[][] ans, int[][] adjMatrix, int newColor, int[] deltaRow,
			int[] deltaColumn, int initialColor) {

		ans[row][column] = newColor;

		int n = adjMatrix.length;
		int m = adjMatrix[0].length;

		for (int i = 0; i < 4; i++) { // charo padosi ke index delta array se lekar jodane ke liye

			int newRow = row + deltaRow[i];
			int newColumn = column + deltaColumn[i];

			if (newRow >= 0 && newRow < n && newColumn >= 0 && newColumn < m
			// array index bound ka exception adjMatrix se na aa jaye
					&& adjMatrix[newRow][newColumn] == initialColor && ans[newRow][newColumn] != newColor) {

				dfs(newRow, newColumn, ans, adjMatrix, newColor, deltaRow, deltaColumn, initialColor);
			}
		}
	}

	private static int[][] getUDUWGraphAdjList() {
		int m = 3; // no of rows
		int n = 3; // no of columns
		int[][] adjMatrix = new int[m][n];

		adjMatrix[0][0] = 1;
		adjMatrix[0][1] = 1;
		adjMatrix[0][2] = 1;

		adjMatrix[1][0] = 2;
		adjMatrix[1][1] = 2;
		adjMatrix[1][2] = 0;

		adjMatrix[2][0] = 2;
		adjMatrix[2][1] = 2;
		adjMatrix[2][2] = 2;

		return adjMatrix;
	}
}
