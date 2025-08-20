package hashset;

import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {

        System.out.println(hash(Integer.valueOf(8)));

        //Randomized data structures
        //not maintaining insertion order
        //not maintaining the sorted manner
        //maintains random order
        //best in search , insert , delete operations : O(1)

        HashSet<Integer> hs = new HashSet<>();
        hs.add(100);
        hs.add(2);
        hs.add(6);
        hs.add(1000);
        hs.add(20);
        hs.add(600);//O(1)

        System.out.println(hs.toString());
        System.out.println(hs.contains(20));//O(1)
        hs.remove(20);//O(1)
        System.out.println(hs.toString());
    }

    static final int hash(Object key) {
        int h = key.hashCode();
        int p = (h >>> 16);
        return h ^ p;
    }
}
