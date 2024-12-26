package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Nearest1DistanceForEachCell {

	private static class Pair {
		int row, col;
		int step;

		public Pair(int row, int col, int step) {
			super();
			this.row = row;
			this.col = col;
			this.step = step;
		}
	}

	public static void main(String[] args) {

		int[][] adjMatrix = getUDUWGraphAdjList();

		int resultantMatrix[][] = nearsetDistance(adjMatrix);
		for (int hh[] : resultantMatrix) {
			for (int j : hh) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static int[][] nearsetDistance(int[][] adjMatrix) {
		int n = adjMatrix.length;
		int m = adjMatrix[0].length;
		int distanceMatrix[][] = new int[n][m];
		Queue<Pair> queue = new LinkedList<Pair>();

		int vis[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (adjMatrix[i][j] == 1) {
					queue.add(new Pair(i, j, 0));// adding all the ones in queue with 0 distance
					vis[i][j] = 1;
				} else {
					vis[i][j] = 0;// for all other cells which value is not 1 mark as non visited cell
				}
			}
		}

		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, 1, 0, -1 };

		// time complexity n*m*4

		while (!queue.isEmpty()) {

			int row = queue.peek().row;
			int column = queue.peek().col;
			int step = queue.peek().step;
			queue.remove();

			distanceMatrix[row][column] = step;// add the respective step in resultant array

			for (int i = 0; i < 4; i++) { // charo padosi ke index delta array se lekar jodane ke liye
				int newRow = row + deltaRow[i];
				int newColumn = column + deltaColumn[i];

				if (newRow >= 0 && newRow < n && newColumn >= 0 && newColumn < m
				// array index bound ka exception adjMatrix se na aa jaye
						&& vis[newRow][newColumn] == 0) {

					queue.add(new Pair(newRow, newColumn, step + 1));
					vis[newRow][newColumn] = 1;

				}
			}
		}

		return distanceMatrix;
	}

	private static int[][] getUDUWGraphAdjList() {
		int m = 3; // no of rows
		int n = 3; // no of columns
		int[][] adjMatrix = new int[m][n];

		adjMatrix[0][0] = 0;
		adjMatrix[0][1] = 0;
		adjMatrix[0][2] = 0;

		adjMatrix[1][0] = 0;
		adjMatrix[1][1] = 1;
		adjMatrix[1][2] = 0;

		adjMatrix[2][0] = 1;
		adjMatrix[2][1] = 0;
		adjMatrix[2][2] = 1;

		return adjMatrix;
	}

}
