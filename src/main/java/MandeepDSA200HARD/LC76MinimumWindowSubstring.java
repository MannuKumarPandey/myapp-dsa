package MandeepDSA200HARD;

import java.util.HashMap;
import java.util.Map;

public class LC76MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        int countOfAllDifferentCharactersInMap = map.size();

        int left = 0, right = 0;
        int howManyCharactersMatchedYet = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        // if it was not possible to form that target string with any of the substring then we will return -1
        //otherwise ans[1] will have the first index of char from target and ans[2] will have the last index of
        // of target and at last we will return s.subString(ans[1], ans[2]+1);
        //ans[0] is containing the length of the found string which had all characters

        int[] ans = {-1, 0, 0};

        while (right < s.length()) {

            char c = s.charAt(right);

            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            //if original map is containing this character with same frequency which we have in new map
            //means for one character of original map is formed or matched.
            if (map.containsKey(c) && windowCounts.get(c) == map.get(c)) {
                howManyCharactersMatchedYet++;
            }

            while (left <= right && howManyCharactersMatchedYet == countOfAllDifferentCharactersInMap) {
                //if it reaches here means we have found the first set of result
                c = s.charAt(left);

                //updating the answer: if its the first time found string or found string length is lessThan ans[0]
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (map.containsKey(c) && windowCounts.get(c) < map.get(c)) {
                    howManyCharactersMatchedYet--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }


}
