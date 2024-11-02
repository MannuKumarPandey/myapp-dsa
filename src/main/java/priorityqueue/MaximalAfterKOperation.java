package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalAfterKOperation {

    public static void main(String[] args) {
        System.out.println(maxKelements(new int[] { 1, 10, 3, 3, 3 }, 3));
    }

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int j : nums) {
            maxHeap.add(j);
        }

        long result = 0;

        while (k > 0) {
            int top = maxHeap.remove();
            result = result + top;
            double d = ((double)top / 3);
            int c = (int) Math.ceil(d);
            maxHeap.add(c);
            k--;
        }

        return result;

    }
}

