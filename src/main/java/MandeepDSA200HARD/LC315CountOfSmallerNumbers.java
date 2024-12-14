package MandeepDSA200HARD;

import java.util.Arrays;
import java.util.List;

public class LC315CountOfSmallerNumbers {

    ///using merge sort:

    public static void main(String[] args) {
        LC315CountOfSmallerNumbers sol = new LC315CountOfSmallerNumbers();
        int[] nums = {5, 2, 6, 1};
        System.out.println(sol.countSmaller(nums)); // Output: [2, 1, 1, 0]
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Pair[] arr = new Pair[n];

        // Initialize the Pair array with values and their original indices
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
            result[i] = 0;
        }

        // Perform merge sort
        mergeSort(arr, 0, n - 1, result);
        return Arrays.asList(result);
    }

    private void mergeSort(Pair[] arr, int left, int right, Integer[] result) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, result);       // Sort left half
        mergeSort(arr, mid + 1, right, result); // Sort right half
        merge(arr, left, mid, right, result);   // Merge two halves
    }

    private void merge(Pair[] arr, int left, int mid, int right, Integer[] result) {
        Pair[] temp = new Pair[right - left + 1];
        int i = left;        // Pointer for left half
        int j = mid + 1;     // Pointer for right half
        int k = 0;           // Pointer for merged array
        int count = 0;       // Count of elements moved from the right half

        while (i <= mid && j <= right) {
            if (arr[i].value <= arr[j].value) {
                // Count stays the same for the left element
                temp[k++] = arr[i];
                result[arr[i].index] += count; // Add count of smaller elements
                i++;
            } else {
                // Element from right is smaller, increment count
                temp[k++] = arr[j];
                count++;
                j++;
            }
        }

        // Copy remaining elements from the left half
        while (i <= mid) {
            temp[k++] = arr[i];
            result[arr[i].index] += count; // Add count of smaller elements
            i++;
        }

        // Copy remaining elements from the right half
        while (j <= right) {
            temp[k++] = arr[j];
            j++;
        }

        // Copy merged elements back to the original array
        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
    }

    // Helper class to store value and its original index
    private static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
