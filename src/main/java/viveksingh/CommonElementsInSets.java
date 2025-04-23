package viveksingh;

import java.util.HashSet;
import java.util.Set;

public class CommonElementsInSets {
    public static void main(String[] args) {
        Set<Integer> hs1 = new HashSet<>();
        hs1.add(100);
        hs1.add(200);
        hs1.add(300);
        hs1.add(400);

        Set<Integer> hs2 = new HashSet<>();
        hs2.add(10);
        hs2.add(200);
        hs2.add(300);
        hs2.add(40);

        for(int a: hs1){
            if(hs2.contains(a)){
                System.out.println(a);
            }
        }

    }
}
