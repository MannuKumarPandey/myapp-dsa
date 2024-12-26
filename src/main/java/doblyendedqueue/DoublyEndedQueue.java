package doblyendedqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoublyEndedQueue {

    public static void main(String[] args) {

        /*internally Deque extends Queue
        Queue Method Equivalent Deque Method
        add(e)                  addLast(e)
        offer(e)                offerLast(e)
        remove()                removeFirst()
        poll()                  pollFirst()
        element()               getFirst()
        peek()                  peekFirst()*/

        /*queue ya deque ka offer method use karna jyada fayade mand hai because
                in case of queue or dequeue is full and then also if we try to insert some
                elements then it will never throw any IllegalStateException exception
                otherwise add() method with throw IllegalStateException exception if
        queue or dequeue is already full.*/




        /*esi hi similar situation hoti hai poll and remove() method ke case me.
        Jab queue or deque empty ho aur tab  ham remove() method chalaye to
        wo  IllegalStateException exxception throw karega jabki poll ()
        null return karega na ki exception thorw karega.*/


        /*Note: start using offer and poll() for queue and dequeue.*/

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(100);
        deque.offerFirst(200);
        deque.offerFirst(300);
        deque.offerFirst(400);
        deque.offerFirst(500);
        deque.offerFirst(600);
        deque.offerFirst(700);
        deque.offerFirst(800);
        deque.offerFirst(900);
        deque.offerFirst(1000);

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerLast(6);
        deque.offerLast(7);
        deque.offerLast(8);
        deque.offerLast(9);
        deque.offerLast(10);


        System.out.println(deque.toString());


        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());


        System.out.println(deque.contains(8));

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println(deque.removeFirstOccurrence(8));

        System.out.println(deque.size());

    }
}
