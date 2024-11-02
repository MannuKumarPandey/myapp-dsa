package math;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt(""));
    }


    public int romanToInt(String s) {

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);
        hm.put("IV", 4);
        hm.put("IX", 9);
        hm.put("XL", 40);
        hm.put("XC", 90);
        hm.put("CD", 400);
        hm.put("CM", 900);


        int result = 0;
        int i = 0;
        while (i < s.length()) {
            String subString = s.substring(i, i + 2);
            if (subString.equals("IV") || subString.equals("IX") || subString.equals("XL") || subString.equals("XC") || subString.equals("CD") || subString.equals("CM")) {
                i = i + 2;
                result = result + hm.get(subString);
            } else {
                result = result + hm.get(subString);
                i = i + 1;
            }
        }
        /*
         * if(i == s.length()-1) { result = result + hm.get(s.substring(i)); }
         */


        return result;
    }


}

