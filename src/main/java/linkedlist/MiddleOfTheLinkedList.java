package linkedlist;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {

        ListNode node = new ListNode(1, null);
        node.next = new ListNode(2, null);
        node.next.next = new ListNode(3, null);
        node.next.next.next = new ListNode(4, null);
        node.next.next.next.next = new ListNode(5, null);
        node.next.next.next.next.next = new ListNode(6, null);

        ListNode Res = middleNode(node);
        System.out.println(Res.val);
    }

    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = -1;

        if (count % 2 == 0) {
            mid = count / 2 + 1;
        } else {
            mid = count / 2;
        }

        for (int i = 0; i < mid - 1; i++) {
            head = head.next;
        }
        return head;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

