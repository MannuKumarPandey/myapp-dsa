package MandeepDSA200HARD;

public class LC327CountOfRangeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 5, -1};
        int lower = -2;
        int upper = 2;
        System.out.println(countRangeSum(nums, lower, upper));

    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;

        // Step 1: Calculate Prefix Sums
        int n = nums.length;
        long[] prefixSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        // Step 2: Use Merge Sort to Count Range Sums
        return countAndMergeSort(prefixSums, 0, n, lower, upper);
    }

    private static int countAndMergeSort(long[] prefixSums, int start, int end, int lower, int upper) {
        if (start >= end) return 0; // Base case: single element

        int mid = start + (end - start) / 2;

        // Count in left and right halves
        int count = countAndMergeSort(prefixSums, start, mid, lower, upper) +
                countAndMergeSort(prefixSums, mid + 1, end, lower, upper);

        // Count valid ranges crossing the two halves
        int low = mid + 1, high = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (low <= end && prefixSums[low] - prefixSums[i] < lower) low++;
            while (high <= end && prefixSums[high] - prefixSums[i] <= upper) high++;
            count += high - low;
        }

        // Merge the two halves
        merge(prefixSums, start, mid, end);
        return count;
    }

    private static void merge(long[] prefixSums, int start, int mid, int end) {
        long[] temp = new long[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        // Merge two sorted halves
        while (i <= mid && j <= end) {
            if (prefixSums[i] <= prefixSums[j]) {
                temp[k++] = prefixSums[i++];
            } else {
                temp[k++] = prefixSums[j++];
            }
        }

        while (i <= mid) temp[k++] = prefixSums[i++];
        while (j <= end) temp[k++] = prefixSums[j++];

        // Copy back into the original array
        System.arraycopy(temp, 0, prefixSums, start, temp.length);
    }
}
