package linkedlist;

public class LinkedList2 {

    public static void main(String[] args) {
        LinkedListMeraWala l = new LinkedListMeraWala();
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(225);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(400);
        l.add(100);
        l.add(200);
        l.add(898989898);


        l.print();
        System.out.println("==================================================");
        System.out.println(l.size);
        System.out.println("=========================");
        System.out.println(l.findLast());
        System.out.println("=============================");
        System.out.println(l.find10th());
    }

}

class LinkedListMeraWala {

    ListNode head;
    int size;


    // complexity of O(n)
    void add(int data) {
        if (head == null) {
            head = new ListNode(data);
            size++;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(data);
            size ++;
        }
    }

    void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    int size() {
        return size;
    }

    int findLast() {
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
    }



    int find10th() {
        ListNode temp = head;
        int i = 1;
        while(i<10) {
            temp = temp.next;
            i++;
        }

        return temp.data;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        ListNode() {
            this.next = null;
        }

    }
}
