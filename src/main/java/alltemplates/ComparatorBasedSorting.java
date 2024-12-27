package alltemplates;

import java.util.Arrays;

public class ComparatorBasedSorting {
    public static void main(String[] args) {
        int[][] arr = {{3, 5}, {1, 7}, {4, 2}};

        // Sort by the first element, and then by the second element
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Print sorted array
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

}
