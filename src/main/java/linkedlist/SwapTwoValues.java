package linkedlist;


public class SwapTwoValues {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        node.next = new ListNode(2, null);
        node.next.next = new ListNode(3, null);
        node.next.next.next = new ListNode(4, null);
        node.next.next.next.next = new ListNode(5, null);

        ListNode Res = swapNodes(node, 2);
        // TODO Auto-generated method stub

        ListNode a = Res;
        while (a != null) {
            System.out.print(a.data + " ");
            a = a.next;
        }

    }


    public static ListNode swapNodes(ListNode head, int k) {

        int totalLen = 0;
        ListNode temp = head;

        while (temp != null) {
            totalLen = totalLen + 1;
            temp = temp.next;
        }


        ListNode temp1 = head;
        ListNode temp2 = head;

        int last = totalLen + 1 - k;

        int a = 1;
        while (a < k) {
            temp1 = temp1.next;
            a++;
        }

        int b = 1;
        while (b < last) {
            temp2 = temp2.next;
            b++;
        }


        int tempD = temp1.data;
        temp1.data = temp2.data;
        temp2.data = tempD;

        return head;

    }

}
