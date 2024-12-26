package binarysearch;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14};
        int target = 28;

        System.out.println(binarySearch(arr, 0, arr.length - 1, target));
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {

        if (start > end) {
            return false;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return binarySearch(arr, start, mid - 1, target);
        }
        return binarySearch(arr, mid + 1, end, target);
    }
}
