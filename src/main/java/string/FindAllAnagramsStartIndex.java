package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsStartIndex {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc").toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        if (s.length() < p.length()) return res;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : p.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        int i = 0;
        int begin = 0;
        while (i < s.length()) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) counter--;
            }

            i++;

            while (counter == 0) {
                char temp = s.charAt(begin);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        counter++;
                    }
                }
                if (i - begin == p.length()) {
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
    }
}
