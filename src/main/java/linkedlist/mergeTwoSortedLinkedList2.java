package linkedlist;

public class mergeTwoSortedLinkedList2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);


        ListNode res = mergeTwoLists(node1, node2);

        ListNode temp = res;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode();
        ListNode tempRes = res;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1.next != null && temp2.next != null) {
            if (temp1.val <= temp2.val) {
                tempRes.next = new ListNode(temp1.val);
                tempRes = tempRes.next;
                temp1 = temp1.next;
            } else {
                tempRes.next = new ListNode(temp2.val);
                tempRes = tempRes.next;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null) {
            tempRes.next = new ListNode(temp1.val);
            tempRes = tempRes.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            tempRes.next = new ListNode(temp2.val);
            tempRes = tempRes.next;
            temp2 = temp2.next;
        }
        return res.next;
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
