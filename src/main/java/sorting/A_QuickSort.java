package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_QuickSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[]{4, 6, 2, 5, 7, 9, 1, 3});
        int n = arr.size();
        System.out.println("Before Using quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        arr = quickSort(arr);
        System.out.println("After quick sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    static int partition(List<Integer> arr, int low, int high) {
        // use to do the partition for the same to get the adject position for the pivot
        // element
        int pivot = arr.get(low);
        // Considering first element as pivot element
        int i = low;
        int j = high;

        while (i < j) {
            // i ko tab tak badhaiye jab tak pivot se bada element na mil jaye
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            // j ko tab tak ghataiye jab tak pivot se chhota element na mil jaye
            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }

            // agar i ko j cross kar gya to swap kar dijiye
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        // at last low and j wale ko swap kar dijiye
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
        // returning the partition index matlab wo index sorted and proper position par
        // hai
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high); // first call
            qs(arr, low, pIndex - 1); // second call for smaller sub array
            qs(arr, pIndex + 1, high); // third call for greater subarray
        }
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here.
        qs(arr, 0, arr.size() - 1);
        return arr;
    }
}
