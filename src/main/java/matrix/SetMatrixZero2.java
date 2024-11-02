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

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    Arrays.fill(result[i], 0);
                    for (int kk = 0; kk < row; kk++) {
                        result[kk][i] = 0;
                    }
                }
            }
        }
        return matrix = result;
    }
}

