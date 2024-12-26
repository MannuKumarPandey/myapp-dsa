package graph;

public class ConverOtoX {

	public static void main(String[] args) {

		char[][] adjMatrix = getUDUWGraphAdjList();

		System.out.println("Before convert Call :::::::::::::::::::");
		for (char hh[] : adjMatrix) {
			for (char j : hh) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		char resultantMatrix[][] = fill(5, 5, adjMatrix);

		System.out.println("After Call ::::::::::::::::::::::::::::::::::::");
		for (char hh[] : resultantMatrix) {
			for (char j : hh) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static char[][] fill(int n, int m, char[][] adjMatrix) {
		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, 1, 0, -1 };

		int vis[][] = new int[n][m];

		// traverse first and last row to find boundry Os
		for (int j = 0; j < m; j++) {
			// first row dfs call
			if (vis[0][j] == 0 && adjMatrix[0][j] == 'O') {
				dfs(0, j, vis, adjMatrix, deltaRow, deltaColumn);
			}

			// last row dfs call
			if (vis[n - 1][j] == 0 && adjMatrix[n - 1][j] == 'O') {
				dfs(n - 1, j, vis, adjMatrix, deltaRow, deltaColumn);
			}
		}

		// traverse first and last column to find boundry Os
		for (int i = 0; i < n; i++) {
			// first column dfs call
			if (vis[i][0] == 0 && adjMatrix[i][0] == 'O') {
				dfs(i, 0, vis, adjMatrix, deltaRow, deltaColumn);
			}

			// last row dfs call
			if (vis[i][m - 1] == 0 && adjMatrix[i][m - 1] == 'O') {
				dfs(i, m - 1, vis, adjMatrix, deltaRow, deltaColumn);
			}
		}

		// changing all the O to X in adjMatrix

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (vis[i][j] == 0 && adjMatrix[i][j] == 'O') {
					adjMatrix[i][j] = 'X';
				}
			}
		}
		return adjMatrix;
	}

	private static void dfs(int row, int column, int vis[][], char adjMatrix[][], int[] deltaRow, int[] deltaColumn) {
		vis[row][column] = 1;
		int n = adjMatrix.length;
		int m = adjMatrix[0].length;
		// check for top, right, bottom, left

		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRow[i];
			int newColumn = column + deltaColumn[i];
			if (newRow >= 0 && newRow < n && newColumn >= 0 && newColumn < m && vis[newRow][newColumn] == 0
					&& adjMatrix[newRow][newColumn] == 'O') {
				dfs(newRow, newColumn, vis, adjMatrix, deltaRow, deltaColumn);

			}
		}
	}

	private static char[][] getUDUWGraphAdjList() {
		int m = 5; // no of rows
		int n = 5; // no of columns
		char[][] adjMatrix = new char[m][n];

		adjMatrix[0][0] = 'X';
		adjMatrix[0][1] = 'X';
		adjMatrix[0][2] = 'X';
		adjMatrix[0][3] = 'X';
		adjMatrix[0][4] = 'X';

		adjMatrix[1][0] = 'X';
		adjMatrix[1][1] = 'O';
		adjMatrix[1][2] = 'O';
		adjMatrix[1][3] = 'X';
		adjMatrix[1][4] = 'O';

		adjMatrix[2][0] = 'X';
		adjMatrix[2][1] = 'X';
		adjMatrix[2][2] = 'O';
		adjMatrix[2][3] = 'X';
		adjMatrix[2][4] = 'O';

		adjMatrix[3][0] = 'X';
		adjMatrix[3][1] = 'O';
		adjMatrix[3][2] = 'X';
		adjMatrix[3][3] = 'O';
		adjMatrix[3][4] = 'X';

		adjMatrix[4][0] = 'O';
		adjMatrix[4][1] = 'O';
		adjMatrix[4][2] = 'X';
		adjMatrix[4][3] = 'X';
		adjMatrix[4][4] = 'X';

		return adjMatrix;
	}

}
