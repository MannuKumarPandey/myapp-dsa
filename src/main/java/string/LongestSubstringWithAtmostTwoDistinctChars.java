package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostTwoDistinctChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int longSubString = 0;
        Map<Character, Integer> map = new HashMap<>();
        int frwdPointer = 0;
        int backPointer = 0;
        while (frwdPointer < s.length()) {
            int j = frwdPointer;
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 0);
            }
            while (j < s.length() && s.charAt(frwdPointer) == s.charAt(j)) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                j += 1;
            }
            // System.out.println("Before Deletion: " + map);

            if (map.size() > 2) {
                while (map.size() > 2) {
                    if (map.containsKey(s.charAt(backPointer))) {
                        map.put(s.charAt(backPointer), map.get(s.charAt(backPointer)) - 1);
                        if (map.get(s.charAt(backPointer)) == 0) {
                            map.remove(s.charAt(backPointer));
                        }
                    }

                    backPointer += 1;
                }
            }

            if (map.size() <= 2) {
                int totalChar = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    totalChar += entry.getValue();
                }
                longSubString = Math.max(longSubString, totalChar);
            }
            //System.out.println("After Deletion: " + map);
            frwdPointer = j;
        }
        return longSubString;
    }

}
