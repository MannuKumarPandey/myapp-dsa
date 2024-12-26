package prefixsuffixoperations;

import java.util.Arrays;

public class RangeQuery {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3, 3, 4};
        int[] low = new int[]{0, 2};
        int[] high = new int[]{2, 4};

        Arrays.sort(arr);

        int[] res = new int[low.length];
        int len = low.length;

        for (int i = 0; i < len; i++) {

            int left = binarySearchModIterative(0, arr.length - 1, arr, false, low[i]);
            int right = binarySearchModIterative(0, arr.length - 1, arr, true, high[i]);

            res[i] = right - left + 1;

        }

        for (int jj : res) {
            System.out.println(jj);
        }

    }

    public static int binarySearchModIterative(int start, int end, int arr[], boolean direction, int target) {

        int res = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                if (!direction) {
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

