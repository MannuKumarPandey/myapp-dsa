package hashset;

import java.util.TreeSet;

public class HashSetTestSubSet {


    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(10);
        ts.add(5);
        ts.add(5);
        ts.add(7);
        ts.add(6);
        ts.add(11);
        System.out.println(ts.toString());
        //[5, 6, 7, 10, 11]
        System.out.println(ts.subSet(5,true,10, true).size());
        System.out.println(ts.ceiling(8));
        System.out.println(ts.floor(8));


    }

}
