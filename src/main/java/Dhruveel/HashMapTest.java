package Dhruveel;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {
        Object o = new int[10];

        //Implementation of Map Interface
        //stores the values in key-> value pair
        //<Integer, Integer> --> first Integer: key , Second Integer: value
        //does not maintain : insertion order
        //does not maintain : sored order
        //it store the data in random manner
        //best in search , insert , delete operations : O(1)
        //key must be unique
        HashMap<Integer, Integer> hm = new HashMap<>();
       /* hm.put(1, 1000);
        hm.put(100, 12);
        hm.put(50, 60);
        hm.put(17, 10);
        hm.put(1, 99); //latest value for that index would be added

        hm.put(1000, 102);
        hm.put(5000, 600);

        System.out.println(hm.toString());*/


        /*int[] arr = new int[]{1, 1, 2, 2, 2, 3};
        for (int a : arr) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        System.out.println(hm.toString());*/


        System.out.println(hm.hashCode());
        int[] arr = new int[]{1, 1, 2, 2, 2, 3};
        for (int a : arr) {
            if(hm.containsKey(a)){
                int freq = hm.get(a);//it will give the value from hm for that key
                freq = freq +1;
                hm.remove(a);
                hm.put(a, freq);
            }else{
                hm.put(a, 1);
            }
        }
        System.out.println(hm.toString());
    }
}






































