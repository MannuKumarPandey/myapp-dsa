package MandeepDSA200Medium;

public class LC147InsertionSortList {


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        insertionSortList(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        ListNode current = head;

        while (current != null) {
            ListNode d  = new ListNode(current.val);
            insert_at_pos(result, d);
            current = current.next;
        }

        return result.next;

    }

    private static void insert_at_pos(ListNode result, ListNode node) {
        ListNode temp = result;


        while (temp.next != null && temp.next.val < node.val) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;

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
