package linkedlist;

public class DeleteNthNodeFromRight {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        ListNode result = removeNthFromEnd(head, 3);
        ListNode temp = result;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        System.out.println(size);
        int fromLeft = size - n;
        if ((fromLeft == 0 || size <= 1)) {
            return head.next;
        }

        ListNode temp = head;
        int i = 1;
        while (i != fromLeft) {
            temp = temp.next;
            i++;

        }

        temp.next = temp.next.next;
        return head;
    }

    public static int size(ListNode head) {
        if (head == null) return 0;
        return 1 + size(head.next);
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
