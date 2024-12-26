package linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

    }


    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();
        ListNode temp = head;
        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null && !s.isEmpty()) {
            int sData = s.pop();
            if (temp.val != sData) {
                return false;
            } else {
                temp = temp.next;
            }
        }
        return true;
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
