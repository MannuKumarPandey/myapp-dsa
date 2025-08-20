package hashtableandmap;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        //Implementation of Map Interface
        //stores the values in key-> value pair
        //<Integer, Integer> --> first Integer: key , Second Integer: value
        //it store the data in soretd manner on basis of key
        //best in search , insert , delete operations : O(1)
        //key must be unique
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        hm.put(1, 1000);
        hm.put(100, 12);
        hm.put(50, 60);
        hm.put(17, 10);
        hm.put(1, 99); //latest value for that index would be added

        hm.put(1000, 102);
        hm.put(5000, 600);

        System.out.println(hm.toString());
    }

}
