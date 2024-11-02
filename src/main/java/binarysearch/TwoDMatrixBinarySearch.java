package binarysearch;

public class TwoDMatrixBinarySearch {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3000));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (matrix[mid / col][mid % col] == target) {
                return true;
            } else if (matrix[mid / col][mid % col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int mid = (start + end) / 2;
        if (matrix[mid / col][mid % col] == target) {
            return true;
        }

        return false;
    }
}
