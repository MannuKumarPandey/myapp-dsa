package string;

import java.util.ArrayList;

public class LongestSubStringWithoutRepeatingChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("umvejcuuk"));
    }

    public static int lengthOfLongestSubstring(String s) {

        // if string is 0 length
        if (s.isEmpty()) {
            return 0;
        }

        int maxLenSubString = Integer.MIN_VALUE;

        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        int i = 0;
        int j = i;
        ArrayList<Character> localA = new ArrayList<>();
        while (i < s.length() && j < s.length()) {
            if (localA.contains(s.charAt(j))) {
                list.add(localA);
                localA.clear();
                i = i + 1;
                j = i;
            } else {
                localA.add(s.charAt(j));
                j++;
            }
        }


        for (ArrayList<Character> a : list) {
            maxLenSubString = Math.max(maxLenSubString, a.size());
        }
        return maxLenSubString;
    }

}

