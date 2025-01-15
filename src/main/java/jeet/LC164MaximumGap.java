package jeet;

import java.util.PriorityQueue;

public class LC164MaximumGap {

    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{3, 6, 9, 1})); // 1 3 6 9
    }


    public static int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int a : nums) {
            minHeap.add(a);
        }


        int maxDifference = Integer.MIN_VALUE;
        int firstValue = minHeap.poll();

        while (!minHeap.isEmpty()) {
            int secondValue = minHeap.poll();
            int diff = secondValue - firstValue;
            maxDifference = Math.max(maxDifference, diff);
            firstValue = secondValue;
        }

        return maxDifference;

    }
}
