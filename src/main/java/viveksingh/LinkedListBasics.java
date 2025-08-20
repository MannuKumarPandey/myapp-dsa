package viveksingh;

public class LinkedListBasics {

    public static void main(String[] args) {
        Node5 ab = new Node5(100);
        ab.next = new Node5(200);
        ab.next.next = new Node5(300);
        ab.next.next.next = new Node5(400);
        ab.next.next.next.next = new Node5(500);

        Node5 i = ab; //i bolega ki mere ko pahla memory ka pta to ap hi de die ho
        while(i != null){ //mai memory ka pta jab tak milta raahega tab tak under jata rahunga
            System.out.println(i.value);
            i = i.next; //i dekho tum jis pate par the uska data tum already print karwa diye ho
            //ab tumko ek aur pta jo wha se dikh rha hai jha tum the upar jump kar jao
        }
        System.out.println();
    }

}




class Node5{
    int value;
    Node5 next;

    Node5(int x){
        this.value = x;
    }
}