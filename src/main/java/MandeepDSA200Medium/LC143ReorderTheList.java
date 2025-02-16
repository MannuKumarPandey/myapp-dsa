package MandeepDSA200Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC143ReorderTheList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

       head =  reorderList(head);

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode reorderList(ListNode head) {
        ListNode result = new ListNode(0);
        Stack<ListNode> stack = new Stack<ListNode>();
        Queue<ListNode> queue = new LinkedList<ListNode>();

        int count = 0;
        ListNode temp = head;
        int i = 0;
        while (temp != null) {
            ListNode t = temp;
           // t.next = null;
            stack.add(t);
            queue.add(t);
            count++;
            temp = temp.next;
        }

        int tt = count / 2;
        ListNode yy = result;
        while (tt > 0) {
            ListNode t2 = queue.poll();
            t2.next = null;
            yy.next = t2;
            ListNode t1 = stack.pop();
            t1.next = null;
            yy.next.next = t1;
            yy = yy.next.next;
            tt--;
        }

        while (!queue.isEmpty()) {
            ListNode t2 = queue.poll();
            t2.next = null;
            yy.next = t2;
            yy = yy.next;
        }

        while (!stack.isEmpty()) {
            ListNode t2 = stack.pop();
            t2.next = null;
            yy.next = t2;
            yy = yy.next;
        }


        head = result.next;
        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
