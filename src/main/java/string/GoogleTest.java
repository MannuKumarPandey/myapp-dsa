package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GoogleTest {


    public static void main(String[] args) {
      /*  //{1:1, A:1, B:1, C:1}------> Set {1,A,B,C}
        String[][] str= new String[][]{{"1","A","B","C"},{"1","G","B","C"},{"3","D","B","C"},{"4","A","B","C"}};

        HashMap<Integer, HashMap<String,Integer>> addreessBook = new HashMap<>();
        for(String[] arr: str){
            HashMap<String,Integer> hmLocal = new HashMap<>();
            for(String curString: arr){
                hmLocal.put(curString, hmLocal.getOrDefault(curString,0)+1);
            }
            addreessBook.put(arr.length, hmLocal);
        }

        //query
        String[] qString = {"1", null, "B", "C"};     //Key,{1: 1, B: 1, C: 1} ------>
        HashMap<String, Integer> hh = new HashMap<>();
        for(String aa: qString){
            if(aa != null){
                hh.put(aa, hh.getOrDefault(hh,0)+1);
            }
        }





        Set<String> cs = hh.keySet();*/




        Set<String> hs1 = new HashSet<>();
        hs1.add("1");
        hs1.add("A");
        hs1.add("B");
        hs1.add("C");

        Set<String> hs2 = new HashSet<>();
        hs2.add("1");
        //hs2.add("A");
        hs2.add("B");
        hs2.add("C");
        if(hs1.containsAll(hs2)){
            System.out.println("query is in address book");
        }

    }
}
