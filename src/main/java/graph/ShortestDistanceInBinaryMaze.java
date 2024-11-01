package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {

	private static class tuple {
		int first, second, third;

		tuple(int _first, int _second, int _third) {
			this.first = _first;
			this.second = _second;
			this.third = _third;
		}
	}

	public static void main(String[] args) {

		int[] source = { 0, 1 };
		int[] destination = { 2, 2 };

		int[][] grid = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 } };

		System.out.println(shortestPath(grid, source, destination));
	}

	private static int shortestPath(int[][] binaryGrid, int[] source, int[] destination) {
		// Edge case : if the source is only the destination

		if (source[0] == destination[0] && source[1] == destination[1]) {
			return 0;
		}

		// Create a queue for storing cells with their distances from source
		// in the form {dist,{cell coordinates pair}}.
		Queue<tuple> queue = new LinkedList<>();
		int n = binaryGrid.length;
		int m = binaryGrid[0].length;

		// Create a distance matrix with initially all the cells marked as
		// unvisited and the source cell is as 0;

		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = (int) (1e9);
			}
		}

		dist[source[0]][source[1]] = 0;
		queue.add(new tuple(0, source[0], source[1]));

		// the following delta rows and delta columns array are created in such a way
		// that
		// each index represents each adjacent node that a cell may have in a direction

		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, 1, 0, -1 };

		// Iterate through the maze by popping the elements out of the queue
		// and pushing whenever a shorter distance to a cell is found

		while (!queue.isEmpty()) {
			tuple t = queue.peek();
			queue.remove();

			int distance = t.first;
			int row = t.second;
			int column = t.third;

			// through this loop, we check the 4 direction adjacent nodes
			// for a shorter path to destination

			for (int i = 0; i < 4; i++) {
				int newR = row + deltaRow[i];
				int newC = column + deltaColumn[i];

				// checking the validity of the cell and updating if dist is shorter
				if (newR >= 0 && newR < n && newC >= 0 && newC < m && binaryGrid[newR][newC] == 1
						&& distance + 1 < dist[newR][newC]) {

					dist[newR][newC] = 1 + distance;
				}
				// Return the distance until the point when
				// we encounter the destination cell.
				if (newR == destination[0] && newC == destination[1])
					return distance + 1;

				// otherwise add it in the queue
				queue.add(new tuple(1 + distance, newR, newC));
			}
		}
		// If no path is found from source to destination.
		return -1;
	}
}
