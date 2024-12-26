package priorityqueue;

import java.util.PriorityQueue;

public class ConnnectingRopesWithMinimumCost {
    public static void main(String[] args) {
        int result = 0;
        int[] arr = new int[]{4, 3, 2, 3};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int h : arr) {
            minHeap.add(h);
        }

        while (minHeap.size() > 1) {
            int a = minHeap.remove();
            int b = minHeap.remove();
            result += a + b;
            minHeap.add(a + b);
        }

        System.out.println(result);
    }
}
