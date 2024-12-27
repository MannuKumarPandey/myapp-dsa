package alltemplates;

public class BackTrackingWithPruning {
    public boolean backtrack(char[][] board, int row, int col) {
        // Base condition
        if (row == board.length) {
            return true;
        }

        // Move to the next row
        int nextRow = col == board[0].length - 1 ? row + 1 : row;
        int nextCol = col == board[0].length - 1 ? 0 : col + 1;

        if (board[row][col] != '.') {
            return backtrack(board, nextRow, nextCol); // Skip already filled cells
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c; // Choose
                if (backtrack(board, nextRow, nextCol)) {
                    return true; // Goal reached
                }
                board[row][col] = '.'; // Un-choose
            }
        }
        return false; // No solution found
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        // Check row, column, and 3x3 sub-grid
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c ||
                    board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
