package viveksingh;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        //key : id value: name
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Rahul");
        map.put(1,"Raju");//HashMap key hamesha unique rakhega
        //in case of duplicate entry of key: jo latest entry hogi usko hi consider karega
       // System.out.println(map.toString());
        map.put(2,"Raju");//value duplicate rakh sakta hai
       // System.out.println(map.toString());

        //map.put(null, "rajesh1");
       // System.out.println(map.toString());
       // map.put(null, "rajesh2");
        //System.out.println(map.toString());

        //map.put("ABC","DEF");// we can not defer the data types while entring the details
        map.put(3,"Kailash");
        map.put(4,"Aman");
        map.put(5,"Akash");

        for(Map.Entry<Integer,String> a: map.entrySet()){
            int key = a.getKey();
            String value = a.getValue();
            System.out.println(key +" , "+ value);
        }


    }
}
