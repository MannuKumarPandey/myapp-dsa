package binarysearch;

public class BinarySearchOnRotatedSortedArray {

    public static void main(String[] args) {

        // unique elements

        int[] arr = new int[]{4, 5, 6, 7, 1, 2, 3};
        int target = 22;
        System.out.println(recurBS(arr, target, 0, arr.length - 1));
    }

    private static boolean recurBS(int[] arr, int target, int left, int right) {
        if (left > right) {
            return false;
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return true;
        }
        //first half is sorted
        else if (arr[mid] > arr[left]) {
            if (target >= arr[left] && target < arr[mid]) {
                return recurBS(arr, target, left, mid - 1);
            } else {
                return recurBS(arr, target, mid + 1, right);
            }
        }
        //else second part is sorted
        else {
            return recurBS(arr, target, mid + 1, right);
        }
    }
}
