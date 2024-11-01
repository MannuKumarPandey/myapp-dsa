package graph;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

	private static class Tuple {
		int distance;
		int row;
		int col;

		public Tuple(int distance, int row, int col) {
			super();
			this.distance = distance;
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
		int ans = minEffort(heights);
		System.out.print(ans);
		System.out.println();
	}

	private static int minEffort(int heights[][]) {
		// create a priority queue containing pairs of cells
		// and their respective distance from source cell to destination cell
		// in the form of {diff, row, cell}

		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);

		int n = heights.length;
		int m = heights[0].length;

		// Create a distance matrix with initially all the cells marked as unvisited
		// and the dist for source cell (0,0) is 0;

		int dist[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = (int) 1e9;
			}
		}

		dist[0][0] = 0;
		pq.add(new Tuple(0, 0, 0));

		// the following delta rows and delta columns array are created such that
		// each index represents each adjacent node that a cell may have in a direction

		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, 1, 0, -1 };

		// iterate through the matrix by popping the elements out of the queue
		// and pushing whenever a shorter distance to a cell is found

		while (pq.size() != 0) {
			Tuple it = pq.peek();
			pq.remove();

			int difference = it.distance;
			int row = it.row;
			int col = it.col;

			// check if we have reached the destination cell,
			// return the current value of the difference which will be minimum.

			if (row == n - 1 && col == m - 1)
				return difference;

			// row - 1, col
			// row, col + 1
			// row - 1, col
			// row, col - 1
			for (int i = 0; i < 4; i++) {
				int newr = row + deltaRow[i];
				int newc = col + deltaColumn[i];

				// Checking validity of the cell.
				if (newr >= 0 && newc >= 0 && newr < n && newc < m) {

					// Effort can be calculated as the max value of differences
					// between the heights of the node and its adjacent nodes
					int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), difference);

					// if the calculated effort is less than the previous value
					// we update as we need the min effort

					if (newEffort < dist[newr][newc]) {
						dist[newr][newc] = newEffort;
						pq.add(new Tuple(newEffort, newr, newc));
					}
				}
			}
		}
		// If the destination is unreachable.
		return 0;
	}

}
