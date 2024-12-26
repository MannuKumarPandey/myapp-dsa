package matrix;

import java.util.Arrays;

public class SetMatrixZero2 {

    public static void main(String[] args) {
        int[][] res = setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        for (int[] k : res) {
            for (int ll : k) {
                System.out.print(ll);
            }
            System.out.println();
        }
    }

    public static int[][] setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        //copying matrixx input into a new result matrix so that input will not get disturbed
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        //traverse for all cells
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) { //which ever cell is having value as 0
                    Arrays.fill(result[i], 0); //fill that complete row as 0
                    for (int kk = 0; kk < row; kk++) { //again fill all columns of that row as 0
                        result[kk][i] = 0;
                    }
                }
            }
        }
        return matrix = result; //reassign result back into the matrix
    }
}

