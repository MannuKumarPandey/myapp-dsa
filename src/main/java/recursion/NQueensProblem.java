package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueensProblem {

	public static void main(String[] args) {
		int N = 4;// 4*4 chess board

		List<List<String>> queen = solveNQueens(N); // list of solutions/ arrangements

		// printing all the arrangements

		int i = 1; // starting from the first solution
		for (List<String> it : queen) {
			System.out.println("Arrangement::: " + i);
			for (String d : it) {
				System.out.println(d + " ");
			}
			System.out.println();
			i++; // increasing for the next solution
		}

	}

	private static List<List<String>> solveNQueens(int n) {

		char[][] board = new char[n][n]; // creating a two D char array as board

		// initializing all the indexes of the board as .

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}

		// creating a list of list of string to store the results
		List<List<String>> res = new ArrayList<List<String>>();
		// calling dfs
		dfs(0, board, res);
		return res;
	}

	private static void dfs(int column, char[][] board, List<List<String>> res) {
		if (column == board.length) {
			// means construct res from 2D char array to List<String>
			res.add(construct(board));
			return;
		}

		for (int row = 0; row < board.length; row++) {
			// validate method is used to know that if the givena board is shared
			// so is it possible to place queen on shared row and column or not
			// means is it valid or not ?
			if (validate(board, row, column)) {
				board[row][column] = 'Q';
				dfs(column + 1, board, res);
				board[row][column] = '.';
			}
		}

	}

	static boolean validate(char[][] board, int row, int col) {
		// Means this method is used to validate that given row column is valid or not
		// to place the queen in board
		int duprow = row; // just keeping row into dupRow
		int dupcol = col; // just keeping column into dupColumn

		// checking in back ward diagonal
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 'Q')
				return false;
			row--;
			col--;
		}

		row = duprow; // adding back the value of dupRow to row
		col = dupcol; // adding back the value of dupColumn to column

		// checking in column wise leftward
		while (col >= 0) {
			if (board[row][col] == 'Q')
				return false;
			col--;
		}

		row = duprow;
		col = dupcol;
		// checking diagonal wise downward left
		while (col >= 0 && row < board.length) {
			if (board[row][col] == 'Q')
				return false;
			col--;
			row++;
		}
		return true;
	}

	private static List<String> construct(char[][] board) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
}
