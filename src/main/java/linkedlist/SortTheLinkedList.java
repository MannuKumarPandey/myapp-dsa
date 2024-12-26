package linkedlist;

public class SortTheLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);

        ListNode res = sortList(listNode);

        ListNode temp = res;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode i = head;

        while (i.next != null) {
            ListNode j = i;
            int temp = Integer.MAX_VALUE;
            ListNode minIndexNode = i;
            while (j != null) {
                if (temp > j.val) {
                    minIndexNode = j;
                    temp = Math.min(temp, j.val);
                }
                j = j.next;
            }
            int h = i.val;
            i.val = minIndexNode.val;
            minIndexNode.val = h;
            i = i.next;
        }

        return head;

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
