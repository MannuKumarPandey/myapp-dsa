package alltemplates;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTemplate {
    public int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

}
