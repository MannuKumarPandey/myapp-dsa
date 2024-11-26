package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class A_HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 4, 3, 8, 7, 9};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int h : arr) {
            maxHeap.add(h);
        }
        int i = arr.length - 1;
        while (!maxHeap.isEmpty()) {
            arr[i--] = maxHeap.remove();
        }
        System.out.println(Arrays.toString(arr));
    }
}
