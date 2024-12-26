package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(100);
        System.out.println(q.peek()==100);
    }
}
