package priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueLRUNature {

    //Priority queue internally extedns AbstractQueue which internally implments Queue Interface
    //So because of having queue datat sturcture internally , It allows duplicate entries.

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(10);

        for(int i: pq){
            System.out.println(i);
        }
        System.out.println("-------------------------");

        pq.remove();

        /*  Means Priority Queue stores the deletion duplicate elements as well.
         In case of deletion of the element which has duplicate values stored in priority
         queue , It will delete the latest entry of the same value. */

        for(int i: pq){
            System.out.println(i);
        }
    }
}