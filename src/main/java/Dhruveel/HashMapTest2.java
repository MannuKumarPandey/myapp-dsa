package Dhruveel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest2 {
    public static void main(String[] args) {

        //HashMap it is an implementation class of Map Interface
        //java.util package holds this class

        //Map: it store the data on basis of key value pairs
        //key must be unique
        //in case of any duplicate entries of key, latest entry will be available
        //hashMap  works on the principle of Hashing Algorithm
        //we basically get the data in : Search-> O(1) insert-> O(1) delete -> O(1)

        //Generics Nature we must provide Wrapper classes of both key and value

        Map<Integer, String> hm1 = new HashMap<Integer,String>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        HashMap<Integer, Integer> hm3 = new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> hm4 = new HashMap<>();

        //insert : put(key, value)
        hm1.put(100,"Mohan");
        hm1.put(100,"Rohit");
        System.out.println(hm1);
        hm1.put(200,"Anmol");
        hm1.put(500,"Raj");

        //to check that the respective key is available or not
        //containsKey()
        System.out.println(hm1.containsKey(500));

        //we can not check the presence of any value directly in the hashmap

        //hashmap can contain duplicate values
        hm1.put(600,"Raj");
        System.out.println(hm1);

        //Data would be randomly stored in the HashMap
        //because of which Accessing the data in index wise manner is not possible

        //Iteration of hashmap
        //a -> temp variable for storing the elements one by one from hm1
        for(Map.Entry<Integer,String> a : hm1.entrySet()){
            System.out.println(a.getKey()+" - " + a.getValue() );
        }

        //Normal for each
        int[] arr = new int[]{1,2,3,4,5,6,7,8,10};
        for(int a: arr){
        }

        //{100=Rohit, 500=Raj, 200=Anmol, 600=Raj}
        System.out.println(hm1);

        //we need to update the entry of key 600 as Madan
        //1 option new insertion
        hm1.put(600, "Madan");


        //{100=Rohit, 500=Raj, 200=Anmol, 600=Madan}
        System.out.println(hm1);

        //we need to update all the even keys with Soham
        for(Map.Entry<Integer,String> a: hm1.entrySet()){
            if (a.getKey()%2 == 0) {
                hm1.put(a.getKey(), "Soham");
            }
        }

        //{100=Soham, 500=Soham, 200=Soham, 600=Soham}
        System.out.println(hm1);

        //we can only remove the entry from hashmap on basis of key
        //In general : deletion must take place on unique fields
        hm1.remove(100);
        //in deletion key associated with the value will also be deleted
        System.out.println(hm1);


        //Key : Randomized data structures : It will not preserve the insertion order of the data

        //clear : reset the values from the hashmap
        //but memory will be still there
       // hm1.clear();
        //System.out.println(hm1);


        System.out.println(hm1.containsValue("Soham"));

        //gerOrDefault: return the default value given in case of key is absence
        //return the associated value of that key if key is present
        System.out.println( hm1.getOrDefault(200,"Empty"));
        System.out.println( hm1.getOrDefault(1000,"Empty"));


        System.out.println(hm1.isEmpty());


        //keySet();
        //given only the set of the keys from the hashmap
        Set<Integer> allKeys = hm1.keySet();
        System.out.println(allKeys);
        System.out.println(hm1);
        hm1.replace(200, "Table");
        System.out.println(hm1);

    }
}
