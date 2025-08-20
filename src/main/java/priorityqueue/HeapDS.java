package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapDS {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(100);
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(110);
        minHeap.add(230);

        System.out.println(minHeap.toString());

        System.out.println(minHeap.poll()); //O(1)
        System.out.println(minHeap.toString());

        System.out.println(minHeap.poll()); //O(1)
        System.out.println(minHeap.toString());

        System.out.println("======================================");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(100);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(110);
        maxHeap.add(230);

        System.out.println(maxHeap.toString());

        System.out.println(maxHeap.poll()); //O(1)
        System.out.println(maxHeap.toString());

        System.out.println(maxHeap.poll()); //O(1)
        System.out.println(maxHeap.toString());

    }
}



