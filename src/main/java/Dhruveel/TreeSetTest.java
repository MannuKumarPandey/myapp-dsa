package Dhruveel;

import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        //unique
        //insertion order will not be maintained
        //sorted manner
        //it does not keep the data with indexed maintained

        // we are unable to delete the values on basis of index iun treeset

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(100);
        ts.add(02);
        ts.add(11);
        ts.add(50);
        ts.add(95);
      //  ts.add(null); null values are not allowed
        ts.add(105);
        ts.add(75);
        ts.add(75);
        System.out.println(ts.toString());

        ts.remove(75);//removal on baqsis of values not on index
        System.out.println(ts.toString());


    }
}
