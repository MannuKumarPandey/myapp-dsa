package binarysearch;

public class BinarySearchTwoIndexes {

    public static void main(String[] args) {
        int[] result = new int[2];

        int[] arr = new int[]{2, 2};
        int target = 3;

        result[0] = binarySearchModIterative(0, arr.length - 1, arr, false, target);
        result[1] = binarySearchModIterative(0, arr.length - 1, arr, true, target);

        System.out.println(result[0] + " " + result[1]);

    }

    public static int binarySearchModIterative(int start, int end, int arr[], boolean direction, int target) {

        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                if (direction == false) {
                    res = mid;
                    end = mid - 1;

                } else {
                    res = mid;
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }

        return res;
    }

}
