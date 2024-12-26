package linkedlist;

import java.util.Stack;

public class TwoNumberAdditionLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = new TwoNumberAdditionLinkedList().addTwoNumbers(l1, l2);
        ListNode ll = result;
        while (ll != null) {
            System.out.print(ll.val + " ");
            ll = ll.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();

        ListNode temp1 = l1;
        while (temp1 != null) {
            s1.push(temp1.val);
            temp1 = temp1.next;
        }

        ListNode temp2 = l2;
        while (temp2 != null) {
            s2.push(temp2.val);
            temp2 = temp2.next;

        }

        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int a = s1.pop();
            int b = s2.pop();
            int item = (carry + a + b) % 10;
            carry = (carry + a + b) / 10;
            s3.push(item);
        }
        while (!s1.isEmpty()) {
            int a = s1.pop();
            int item = (carry + a) % 10;
            carry = (carry + a) / 10;
            s3.push(item);
        }

        while (!s2.isEmpty()) {
            int a = s2.pop();
            int item = (carry + a) % 10;
            carry = (carry + a) / 10;
            s3.push(item);
        }

        ListNode t = new ListNode(0);

        ListNode tempp = t;
        while (!s3.isEmpty()) {
            tempp.next = new ListNode(s3.pop());
            tempp = tempp.next;
        }
        return t.next;

    }

    static class ListNode {
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

