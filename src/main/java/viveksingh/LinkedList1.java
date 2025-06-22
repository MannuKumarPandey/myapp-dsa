package viveksingh;

public class LinkedList1 {

    //ek object ke under dusra object linked hota hai
    //bahar se dekhne par ek object hi dikhega
    //at a moment sirf ek object hi access ho sakta hai
    //dusre object ko access karne ke liye one level down jump karke jana padega
    //helping object as pointer use ho rha tha usko condition ke base par rokna bhi jaruri hai
    //object to object jump karke inke daata access kiye jate hai
    public static void main(String[] args) {
        Node root = new Node(100);
        root.next = new Node(200);
        root.next.next = new Node(300);
        root.next.next.next = new Node(400);
        root.next.next.next.next = new Node(500);

        System.out.println("=============");

        Node temp = root;//helping object hai pointer ki tarah traversal me help karega
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next= null;
    }
}
