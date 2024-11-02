package sorting;

public class SortLinkedList {

    public static void main(String[] args) {


        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);

        ListNode res = sortList(node);

        ListNode temp = res;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    public static ListNode sortList(ListNode head) {

        ListNode tempi = head;

        while (tempi.next != null) {

            // Select the minimum
            int min = Integer.MAX_VALUE;
            ListNode tempj = tempi;

            ListNode tempMinIndex = tempi;

            while (tempj.next != null) {
                if (tempj.val < min) {
                    min = tempj.val;
                    tempMinIndex = tempMinIndex.next;
                }
                tempj = tempj.next;
            }

            // Swap Here
            int temp = min;
            tempMinIndex.val = tempi.val;
            tempi.val = temp;
            tempi = tempi.next;
        }

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

