package binarysearch;

public class BSOnMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 2, 4 ,4}, { 14, 15, 16, 17 }, { 77, 88, 99, 100 } };
        int lastIndex = arr[0].length * arr.length;
        int target = 100;
        System.out.println(bsOnMatrix(arr, 0, lastIndex, target));
    }

    private static boolean bsOnMatrix(int[][] arr, int start, int last, int target) {
        int col = arr[0].length;

        while (start < last) {
            int mid = start + (last - start) / 2; // mid nikalane ke bad hame 2 index wala row and col wana part chahiye
            // row ke liye mid/col
            // col ke liye mid%col

            if (arr[mid / col][mid % col] == target) {
                return true;
            } else if (arr[mid / col][mid % col] > target) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
