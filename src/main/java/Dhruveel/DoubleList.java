package Dhruveel;

import java.util.ArrayList;
import java.util.List;

public class DoubleList {


    public static void main(String[] args) {
        List<List<Integer>>  result = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(200);
        list1.add(600);
        result.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(6);
        result.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1000);
        list3.add(2000);
        list3.add(6000);
        result.add(list3);


        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(8);
        list4.add(9);
        list4.add(10);
        result.add(list4);

        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(5);
        list5.add(6);
        list5.add(7);
        result.add(list5);

        System.out.println(result.toString());

        A aa = new B();



    }
}


class A{

}


class B extends A{
    public static void main(String[] args) {
        A ob = new B();
    }
}
