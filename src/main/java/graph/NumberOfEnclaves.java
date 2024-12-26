package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

	private static class Pair {
		int row;
		int column;

		public Pair(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}

	public static void main(String[] args) {

		int[][] adjMatrix = getUDUWGraphAdjList();

		System.out.println("Input adj Matrix Call :::::::::::::::::::");
		for (int hh[] : adjMatrix) {
			for (int j : hh) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		System.out.println(noOfEnclaves(adjMatrix));
	}

	private static int noOfEnclaves(int[][] adjMatrix) {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		int n= adjMatrix.length;
		int m = adjMatrix[0].length;
		int vis[][] = new int[n][m];
		
		// traverse first row, last row, first column and last column to find boundry 1's
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(i==0 || i== n-1 || j== 0 || j== m-1 ) { // for first row, last row, first col and last column
					if(adjMatrix[i][j] == 1) { // agar bundry cell is containing the 1
						queue.add(new Pair(i,j));
						vis[i][j] =1;
					}
				}
			}
		}
		int deltaRow[] = { -1, 0, 1, 0 };
		int deltaColumn[] = { 0, 1, 0, -1 };
		
		while(!queue.isEmpty()){
			int row = queue.peek().row;
			int column = queue.peek().column;
			
			queue.remove();
			
			for(int i= 0; i<4; i++){
				int newRow = row+deltaRow[i];
				int newColumn = column+deltaColumn[i];
				
				if(newRow >= 0 && newRow < n && newColumn >= 0 && newColumn < m
						&& vis[newRow][newColumn] ==0 && adjMatrix[newRow][newColumn] ==1) {
					queue.add(new Pair(newRow, newColumn));
					vis[newRow][newColumn] = 1;
				}
			}
		}
			
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(adjMatrix[i][j] ==1 && vis[i][j] ==0) {
					count++;
				}
			}
		}
		return count;
	}

	private static int[][] getUDUWGraphAdjList() {
		int n = 5; // no of rows
		int m = 5; // no of columns
		int[][] adjMatrix = new int[n][m];

		adjMatrix[0][0] = 0;
		adjMatrix[0][1] = 0;
		adjMatrix[0][2] = 0;
		adjMatrix[0][3] = 1;
		adjMatrix[0][4] = 1;

		adjMatrix[1][0] = 0;
		adjMatrix[1][1] = 0;
		adjMatrix[1][2] = 1;
		adjMatrix[1][3] = 1;
		adjMatrix[1][4] = 0;

		adjMatrix[2][0] = 0;
		adjMatrix[2][1] = 1;
		adjMatrix[2][2] = 0;
		adjMatrix[2][3] = 0;
		adjMatrix[2][4] = 0;

		adjMatrix[3][0] = 0;
		adjMatrix[3][1] = 1;
		adjMatrix[3][2] = 1;
		adjMatrix[3][3] = 0;
		adjMatrix[3][4] = 0;

		adjMatrix[4][0] = 0;
		adjMatrix[4][1] = 0;
		adjMatrix[4][2] = 0;
		adjMatrix[4][3] = 1;
		adjMatrix[4][4] = 1;

		return adjMatrix;
	}

}
