package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
        //insertion order will be preserved
        //duplicate elements will be added
        //internally stores the elements on basis of LinkedList
        LinkedList<Integer> arlist = new LinkedList<>();
        //In case if we want to perform some operations on the different objects of List Interfaces too,
        //we will be in position to do that
        List<Integer> arlist2 = new LinkedList<>();

        List<Integer> arlist3 = new ArrayList<>();
        arlist2 = arlist3;


        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);
        arlist.add(10);
        arlist.add(20);
        arlist.add(100);
        arlist.add(250);
        arlist.add(1000);
        arlist.add(2);
        arlist.add(100);




        //arlist.clear();//clear methods remove all the data from that list
        //System.out.println(arlist.toString());

        //System.out.println(arlist.contains(2));//Linear search operation: first occurance

        //System.out.println(arlist.indexOf(2));//first occurance of that element
        arlist.set(0,9696);//O(1) operation : replace the updated value at 0th index
        int size = arlist.size();
        /*for(int i=0; i<size; i++){
            //System.out.println(arlist.get(i));
            System.out.println(arlist.getFirst());
            System.out.println(arlist.getLast());
        }*/


        //enhanced for loop / for each loop
        /*for(int a: arlist){
            System.out.println(a);
        }*/


        //System.out.println(arlist.remove(0));//value of that integer at that index returns here
       // System.out.println(arlist.remove(Integer.valueOf(20)));//returns booelan
        /*for(int a: arlist){
            System.out.println(a);
        }*/


        /*arlist.add(0,9999);
        for(int a: arlist){
            System.out.println(a);
        }*/


        /*System.out.println(arlist.toString());
        System.out.println(arlist.get(2));
        arlist.add(0,999);
        System.out.println(arlist.toString());
        arlist.remove(5);
        System.out.println(arlist.toString());
        Collections.sort(arlist);
        System.out.println(arlist.toString());
        System.out.println(Collections.binarySearch(arlist, 2));*/
    }
}
