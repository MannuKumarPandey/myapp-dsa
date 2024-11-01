package recursion;

public class SudokoSolver {

	public static boolean solveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					// finding the . means empty cell and then try to fill characters from 1 to 9

					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							// condition check that if valid to fill 1 to 9 chars
							board[i][j] = c;

							if (solveSudoku(board))
								// if sudoko solver is returning true means sare ke sare cells
								// fill ho gaye hai so return true
								return true;
							else
								board[i][j] = '.';
						}
					}

					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(char[][] board, int row, int col, char c) {
		// validation for board me se row column ke liye jha khali tha wha wo char c dal
		// sakte hai kya

		for (int i = 0; i < 9; i++) {
			if (board[i][col] == c) // pura row same column ke liye kahi wo value pahle se to nahi hai na
				return false;

			if (board[row][i] == c) // pura column same row ke liye kahi wo value pahle se to nahi hai na
				return false;

			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				// withing 3*3 matrix me wo value pahle se to nahi hai na
				return false;
		}
		return true; // agar upar ki sare conditions true hai means valid hai returning true
	}

	public static void main(String[] args) {

		char[][] board = { { '9', '5', '7', '.', '1', '3', '.', '8', '4' },
				{ '4', '8', '3', '.', '5', '7', '1', '.', '6' }, { '.', '1', '2', '.', '4', '9', '5', '3', '7' },
				{ '1', '7', '.', '3', '.', '4', '9', '.', '2' }, { '5', '.', '4', '9', '7', '.', '3', '6', '.' },
				{ '3', '.', '9', '5', '.', '8', '7', '.', '1' }, { '8', '4', '5', '7', '9', '.', '6', '1', '3' },
				{ '.', '9', '1', '.', '3', '6', '.', '7', '5' }, { '7', '.', '6', '1', '8', '5', '4', '.', '9' } };
		solveSudoku(board);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
}
