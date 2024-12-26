package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslandsinGivenAdjMatrix {

	public static void main(String[] args) {
		int n = 5;
		int m = 4;
		int[][] adjMatrix = getUDUWGraphAdjList();
		// To handle the visited nodes condition for adjmatrix , we will maintain 2d
		// matrix
		int[][] vis = new int[n][m];
		int noOfIslands = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (adjMatrix[i][j] == 1 && vis[i][j] == 0 ) {
					vis = bfsTraversalAdjMatrix(adjMatrix, new Pair(i, j), vis);
					noOfIslands++;
				}
			}
		}
		System.out.println("noOfIslands are :::"+ noOfIslands);
	}

	private static int[][] bfsTraversalAdjMatrix(int[][] adjMatrix, Pair pair,
			int[][] vis) {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		vis[pair.getStartingPointrow()][pair.getStartingPointColumn()] = 1;
		queue.add(pair);
		
		while(!queue.isEmpty()) {
			
			int row = queue.peek().getStartingPointrow();
			int col = queue.peek().getStartingPointColumn();
			queue.remove();
			
			// Niche bane hue for lops me deltaRow aur deltaColumn ka matlab hai ki max changes in row and column to get 
			// Kisi bhi node ke all 8 directions padosi -1 se +1 ke addition se mil jayenge
			
			for(int deltaRow = -1; deltaRow <= 1; deltaRow++) {
				for(int deltaCol = -1; deltaCol <= 1; deltaCol++) {
					int nRow = row + deltaRow;
					int nCol = col + deltaCol;
					if(nRow >= 0 && nRow < 5 && nCol >= 0 && nCol < 4
							&& adjMatrix[nRow][nCol] == 1 && vis[nRow][nCol] ==0 ) {
						vis[nRow][nCol] = 1;
						queue.add(new Pair(nRow, nCol));
					}
				}
			}
		}
		return vis;
	}

	static class Pair {
		
		private int startingPointrow;
		private int startingPointColumn;

		public Pair(int startingPointrow, int startingPointColumn) {
			super();
			this.startingPointrow = startingPointrow;
			this.startingPointColumn = startingPointColumn;
		}

		public int getStartingPointrow() {
			return startingPointrow;
		}

		public void setStartingPointrow(int startingPointrow) {
			this.startingPointrow = startingPointrow;
		}

		public int getStartingPointColumn() {
			return startingPointColumn;
		}

		public void setStartingPointColumn(int startingPointColumn) {
			this.startingPointColumn = startingPointColumn;
		}
	}

	private static int[][] getUDUWGraphAdjList() {
		int n = 5; // no of rows
		int m = 4; // no of columns
		int[][] adjMatrix = new int[n][m];

		adjMatrix[0][0] = 0;
		adjMatrix[0][1] = 1;
		adjMatrix[0][2] = 1;
		adjMatrix[0][3] = 0;

		adjMatrix[1][0] = 0;
		adjMatrix[1][1] = 1;
		adjMatrix[1][2] = 1;
		adjMatrix[1][3] = 0;

		adjMatrix[2][0] = 0;
		adjMatrix[2][1] = 0;
		adjMatrix[2][2] = 1;
		adjMatrix[2][3] = 0;

		adjMatrix[3][0] = 0;
		adjMatrix[3][1] = 0;
		adjMatrix[3][2] = 0;
		adjMatrix[3][3] = 0;

		adjMatrix[4][0] = 1;
		adjMatrix[4][1] = 1;
		adjMatrix[4][2] = 0;
		adjMatrix[4][3] = 1;

		return adjMatrix;
	}
}
