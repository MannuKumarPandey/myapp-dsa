package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30SubStringOfConcatenationOfAllWords {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}).toString());
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        int wordLength = words[0].length();
        int windowLength = wordLength * words.length;

        //i - left pointer and j - right pointer
        int i = 0, j = 0;
        while (j < s.length()) {

            //sending j to the last index of the window
            if (j - i + 1 < windowLength) {
                j++;
            }

            else if (j - i + 1 == windowLength) {
                // if i is at left pointing index, j is at the last index of window size then
                //take the substring
                //preparing substring of window size from given input string

                /*0 index se leakr totalstringlength-windowsize tak ek ek karke sare window size ke barabar
                        ke substring me ye same

                        game karte rahenge*/

                String sub = s.substring(i, j + 1);

                Map<String, Integer> map2 = new HashMap<>();

                int index = 0;

                while (index < sub.length()) {
                    //now breaking the substring words of wordlength from sub string of fullwindow
                    String temp = sub.substring(index, index + wordLength);
                    map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                    index += wordLength;
                }

                // if both maps are matching means we can form that window  post concatenating all words from words array
                if (map.equals(map2))
                    ans.add(i);
                i++;
                j++;
            }
        }
        return ans;
    }
}

