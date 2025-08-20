package arrays;

import java.util.HashMap;
import java.util.Map;

public class FreqArayTest {

    public static void main(String[] args) {
        int[] arr = {-5, 1000, 1000,200,200,200, -5,-5,1000,99};


        String ss = Integer.toBinaryString(1000);
        System.out.println(ss);



        HashMap<Integer, Integer> hm = new HashMap<>();

       /* for(int a: arr){
            hm.put(a, hm.getOrDefault(a,0)+1);
        }*/

        for(int a: arr){
            if(hm.containsKey(a)){
                int freqOfThatElement = hm.get(a);
                hm.put(a,freqOfThatElement+1);
            }else{
                hm.put(a,1);
            }
        }

        for(Map.Entry<Integer,Integer> aa: hm.entrySet()){
            if (aa.getValue()==1) {
                System.out.println(aa.getKey());
                break;
            }
        }
    }
}
