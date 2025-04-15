package MandeepDSA200Medium;


class LC2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) return null;

        //adding the head after 0 node
        ListNode dummy = new ListNode(0, head);

        ListNode prevGroupEnd = dummy;
        ListNode current = head;
        int groupSize = 1;


        while (current != null) {
            ListNode groupStart = current;

            int count = 0;
            ListNode temp = current;
            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }


            if (count % 2 == 0) {
                //here we need to reverse the nodes
                ListNode prev = null;
                ListNode curr = current;
                for (int i = 0; i < count; i++) {
                    ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }

                prevGroupEnd.next = prev;
                groupStart.next = curr;

                prevGroupEnd = groupStart;
                current = curr;
            } else {
                for (int i = 0; i < count; i++) {
                    prevGroupEnd = current;
                    current = current.next;
                }
            }

            groupSize++;


        }

        return dummy.next;

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