package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.List;

public class LC315UsingMergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums)); // Output: [2, 1, 1, 0]
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;

        int[] counts = new int[n];
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, counts, 0, n - 1);

        // Convert the counts array to a list for output
        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private static void mergeSort(int[] nums, int[] indices, int[] counts, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, counts, left, mid);
        mergeSort(nums, indices, counts, mid + 1, right);
        merge(nums, indices, counts, left, mid, right);
    }

    private static void merge(int[] nums, int[] indices, int[] counts, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int[] tempResultantArray = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCounter = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                counts[indices[i]] += rightCounter; // Count smaller elements to the right
                tempResultantArray[k] = indices[i];
                temp[k++] = nums[indices[i++]];
            } else {
                rightCounter++;
                tempResultantArray[k] = indices[j];
                temp[k++] = nums[indices[j++]];
            }
        }

        while (i <= mid) {
            counts[indices[i]] += rightCounter; // Add remaining smaller elements
            tempResultantArray[k] = indices[i];
            temp[k++] = nums[indices[i++]];
        }

        while (j <= right) {
            tempResultantArray[k] = indices[j];
            temp[k++] = nums[indices[j++]];
        }

        // Copy back to original array
        for (int p = 0; p < temp.length; p++) {
            indices[left + p] = tempResultantArray[p];
        }
    }
}
