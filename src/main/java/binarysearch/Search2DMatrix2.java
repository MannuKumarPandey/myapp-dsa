package binarysearch;

public class Search2DMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 263;
        System.out.println(searchMatrix(matrix, target));
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int i = 0;
        int j = col;
        while (i <= row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return false;
    }
}
