package MandeepDSA200HARD;


import java.util.Random;
import java.util.Stack;

class LC1206DesignSkipList {
    Node head;
    Random random;


    /* Initializes an empty skip list with a head node having value -1.
     Uses a Random object to decide whether to promote elements to a higher level.*/
    public LC1206DesignSkipList() {
        head = new Node(-1, null, null, null);
        random = new Random();
    }


    public static void main(String[] args) {
        LC1206DesignSkipList obj = new LC1206DesignSkipList();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        System.out.println(obj.search(0));
        obj.add(4);
        System.out.println(obj.search(1));
        System.out.println(obj.erase(0));
        System.out.println(obj.erase(1));
        System.out.println(obj.search(1));

    }

   /* Starts from the topmost left node (head).
    Moves right while the next node’s value is less than the target.
    If the next node is the target, return true.
    Otherwise, move down one level and repeat.
    If it reaches the bottom level without finding the target, return false.*/

    public boolean search(int target) {
        Node cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val < target) {
                cur = cur.next;
            }
            if (cur.next != null && cur.next.val == target) {
                return true;
            }
            cur = cur.down;
        }
        return false;
    }


    /*Find the correct position at each level and store it in a stack.
    Insert the new node at the lowest level.
    Promote the node (i.e., add it to higher levels) with a 50% probability.
    If promotion happens at the topmost level, add a new level.*/

    public void add(int num) {
        Node cur = head;
        Stack<Node> st = new Stack();
        while (cur != null) {
            while (cur.next != null && cur.next.val < num) {
                cur = cur.next;
            }
            st.push(cur);
            cur = cur.down;
        }
        boolean promote = true;
        Node prevDown = null;
        while (promote && st.size() > 0) {
            cur = st.pop();
            cur.next = new Node(num, cur.next, prevDown, cur);
            if (cur.next.next != null) {
                cur.next.next.prev = cur.next;
            }
            prevDown = cur.next;
            promote = random.nextInt(2) == 0;
        }

        if (promote) {
            head = new Node(-1, null, head, null);
            head.next = new Node(num, null, prevDown, head);
        }
    }



    /*Find the target node by traversing the skip list from top to bottom.
    If not found, return false.
    Delete all occurrences of the node from all levels by adjusting prev and next pointers.
    Return true if the node was found and removed.*/

    public boolean erase(int num) {
        Node cur = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val < num) {
                cur = cur.next;
            }
            if (cur.next != null && cur.next.val == num) {
                cur = cur.next;
                break;
            }
            cur = cur.down;
        }

        if (cur == null)
            return false;

        while (cur != null) {
            cur.prev.next = cur.next;
            if (cur.next != null)
                cur.next.prev = cur.prev;
            cur = cur.down;
        }

        return true;
    }

    public static class Node {
        public int val;
        public Node next, down, prev;

        public Node(int val, Node next, Node down, Node prev) {
            this.val = val;
            this.next = next;
            this.down = down;
            this.prev = prev;
        }
    }
}