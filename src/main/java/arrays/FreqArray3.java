package arrays;

import java.util.HashMap;

public class FreqArray3 {

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
    }
    public static  boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int a: deck){
            hm.put(a, hm.getOrDefault(a,0)+1);
        }
        int min = Integer.MAX_VALUE;


        return hm.values().stream().distinct().count()==1;
    }
}
