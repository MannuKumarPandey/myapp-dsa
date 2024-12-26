package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottaningOranges {
	private static class Pair {
		int row, col;
		int time;

		public Pair(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	public static void main(String[] args) {

		int[][] adjMatrix = getUDUWGraphAdjList();

		System.out.println(orangeRotting(adjMatrix));
	}

	private static int orangeRotting(int[][] adjMatrix) {
		int n = adjMatrix.length;
		int m = adjMatrix[0].length;
		Queue<Pair> queue = new LinkedList<Pair>();

		int vis[][] = new int[n][m];
		int countFresh = 0;

		// mark all the rotten positions at the first time as visitited and store in a
		// queue

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (adjMatrix[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
					vis[i][j] = 2;
				} else {
					vis[i][j] = 0;
				}
				if (adjMatrix[i][j] == 1)
					countFresh++;
			}
		}
		int timeMax = 0;
		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, 1, 0, -1 };
		int cnt = 0;
		while (!queue.isEmpty()) {

			int row = queue.peek().row;
			int column = queue.peek().col;
			int time = queue.peek().time;
			timeMax = Math.max(timeMax, time);
			queue.remove();

			for (int i = 0; i < 4; i++) { // charo padosi ke index delta array se lekar jodane ke liye
				int newRow = row + deltaRow[i];
				int newColumn = column + deltaColumn[i];

				if (newRow >= 0 && newRow < n && newColumn >= 0 && newColumn < m
				// array index bound ka exception adjMatrix se na aa jaye
						&& vis[newRow][newColumn] == 0 && adjMatrix[newRow][newColumn] == 1) {

					queue.add(new Pair(newRow, newColumn, time + 1));
					vis[newRow][newColumn] = 2;
					cnt++;
				}
			}
		}
		if (cnt != countFresh)
			return -1; // matlab agar sare oranges nahi sad paye adjMatrix se to return -1
		return timeMax;
	}

	private static int[][] getUDUWGraphAdjList() {
		int m = 3; // no of rows
		int n = 3; // no of columns
		int[][] adjMatrix = new int[m][n];

		adjMatrix[0][0] = 0;
		adjMatrix[0][1] = 1;
		adjMatrix[0][2] = 2;

		adjMatrix[1][0] = 0;
		adjMatrix[1][1] = 1;
		adjMatrix[1][2] = 1;

		adjMatrix[2][0] = 2;
		adjMatrix[2][1] = 1;
		adjMatrix[2][2] = 1;

		return adjMatrix;
	}

}
