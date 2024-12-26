package hashtableandmap;

import java.util.HashMap;
import java.util.Map;

public class Traversal {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(1, 100);
        hm.put(2, 200);
        hm.put(3, 300);
        hm.put(4, 400);
        hm.put(5, 500);

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
