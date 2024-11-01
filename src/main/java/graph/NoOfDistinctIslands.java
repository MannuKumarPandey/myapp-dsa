package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {

	public static void main(String[] args) {

		int[][] adjMatrix = getUDUWGraphAdjList();
		System.out.println("Input adj Matrix Call :::::::::::::::::::");
		for (int hh[] : adjMatrix) {
			for (int j : hh) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		System.out.println(countDistinctIslands(adjMatrix));
	}

	private static int countDistinctIslands(int[][] adjMatrix) {
		int n = adjMatrix.length;
		int m = adjMatrix[0].length;
		int vis[][] = new int[n][m];

		HashSet<ArrayList<String>> hashSet = new HashSet<>(); // To store the shape of the island

		// Call for all the componenets avauilable in the given graph
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (vis[i][j] == 0 && adjMatrix[i][j] == 1) {
					ArrayList<String> arrayList = new ArrayList<>(); // Saare componenets ke liye ek ek new arrayList
																		// banega
					// here last i and j is going as base index to be substracted from the main
					// indexes.
					dfs(i, j, vis, adjMatrix, arrayList, i, j);
					hashSet.add(arrayList);
				}
			}
		}
		return hashSet.size();
	}

	private static void dfs(int row, int column, int[][] vis, int[][] adjMatrix, ArrayList<String> arrayList, int row0,
			int column0) {
		vis[row][column] = 1;
		arrayList.add(toString(row - row0, column - column0));
		int n = adjMatrix.length;

		int m = adjMatrix[0].length;

		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, -1, 0, 1 };

		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRow[i];
			int newColumn = column + deltaColumn[i];

			if (newRow >= 0 && newRow < n && newColumn >= 0 && newColumn < m && vis[newRow][newColumn] == 0
					&& adjMatrix[newRow][newColumn] == 1) {
				dfs(newRow, newColumn, vis, adjMatrix, arrayList, row0, column0);
			}
		}
	}

	private static String toString(int r, int c) {
		return Integer.toString(r) + " " + Integer.toString(c);
	}

	private static int[][] getUDUWGraphAdjList() {
		int n = 4; // no of rows
		int m = 5; // no of columns
		int[][] adjMatrix = new int[n][m];

		adjMatrix[0][0] = 1;
		adjMatrix[0][1] = 1;
		adjMatrix[0][2] = 0;
		adjMatrix[0][3] = 1;
		adjMatrix[0][4] = 1;

		adjMatrix[1][0] = 1;
		adjMatrix[1][1] = 0;
		adjMatrix[1][2] = 0;
		adjMatrix[1][3] = 0;
		adjMatrix[1][4] = 0;

		adjMatrix[2][0] = 0;
		adjMatrix[2][1] = 0;
		adjMatrix[2][2] = 0;
		adjMatrix[2][3] = 0;
		adjMatrix[2][4] = 1;

		adjMatrix[3][0] = 1;
		adjMatrix[3][1] = 1;
		adjMatrix[3][2] = 0;
		adjMatrix[3][3] = 1;
		adjMatrix[3][4] = 1;

		return adjMatrix;
	}
}
