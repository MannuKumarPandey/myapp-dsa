package priorityqueue;

import java.util.PriorityQueue;

public class KthLargestFromArray {

    public static void main(String[] args) {

        // given an array and k: give kth largest at each index
        // [4,2,1,3]
        int[] arr = new int[]{9, 7, 11, 12, 9, 5, 4, 3};
        int k = 3;
        int len = arr.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = getKthLargestFromArray(arr, 0, i, k);
        }
        for (int j : result) {
            System.out.print(j + " ");
        }

    }

    public static int getKthLargestFromArray(int array[], int start, int end, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(Integer.MIN_VALUE);
        }

        if ((end - start + 1) < k) {
            return -1;
        }
        int q = start;
        while (q <= end) {
            int top = minHeap.poll();
            if (top == Integer.MIN_VALUE) {
                minHeap.add(array[q]);
            } else {
                minHeap.add(Math.max(array[q], top));
            }
            q++;
        }
        return minHeap.poll();
    }

}
