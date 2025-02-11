package Dhruveel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        //insertion order will be preserved
        //duplicate elements will be added
        //internally stores the elements on basis of LinkedList
        LinkedList<Integer> arlist = new LinkedList<>();
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

        System.out.println(arlist.toString());
        System.out.println(arlist.get(2));

        arlist.add(0,999);
        System.out.println(arlist.toString());

        arlist.remove(5);
        System.out.println(arlist.toString());

        Collections.sort(arlist);
        System.out.println(arlist.toString());

        System.out.println(Collections.binarySearch(arlist, 2));

    }
}
