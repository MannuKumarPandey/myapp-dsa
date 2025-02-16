package Dhruveel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        //insertion order will be preserved
        //duplicate elements will be added
        //internally stores the elements on basis of dynamic array
        ArrayList<Integer> arlist = new ArrayList<>();

        //Object creation of arrayList using List
        //ArrayList -> implementation Class of List Interface
        List<Integer> arlist2 = new ArrayList<>();

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
