package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC336PalindromePairs {

    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> result = palindromePairs(words);

        for (List<Integer> temp : result) {
            System.out.println(temp.toString());
        }
    }

    /*Number of cases :
    Case1: If s1 is a blank string, then for any string s2 that is palindrome , s1+s2 and s2+s1 are palindrome.
    Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
    Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.``
    Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome*/

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        if(words == null || words.length == 0){
            return result;
        }

        int len = words.length;

        //storing all the string with its index ion Hashmap
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            hm.put(words[i], i);
        }

        //case when a string will be empty in that case if any word which will be palindrome can be added
        //with empty string and it will form palindrome
        //since all the strings are unique in nature and "" string alllowed means only one "" string can be present in hashmap
        if (hm.containsKey("")) {
            int blankIdx = hm.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i])) {
                    if (i == blankIdx) continue; //skip that index which we have taken as empty
                    result.add(Arrays.asList(blankIdx, i));
                    result.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        //find all string and reverse string pairs
        for (int i = 0; i < words.length; i++) {
            String cur_r = reverse(words[i]);
            if (hm.containsKey(cur_r)) {
                int found = hm.get(cur_r);
                if (found == i) continue;
                result.add(Arrays.asList(i, found));
            }
        }

        //find the pair s1, s2 that
        //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
        //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                if (isPalindrome(cur.substring(0, cut))) {
                    String cut_r = reverse(cur.substring(cut));
                    if (hm.containsKey(cut_r)) {
                        int found = hm.get(cut_r);
                        if (found == i) continue;
                        result.add(Arrays.asList(found, i));
                    }
                }
                if (isPalindrome(cur.substring(cut))) {
                    String cut_r = reverse(cur.substring(0, cut));
                    if (hm.containsKey(cut_r)) {
                        int found = hm.get(cut_r);
                        if (found == i) continue;
                        result.add(Arrays.asList(i, found));
                    }
                }
            }
        }
        return result;
    }

    public static String reverse(String s) {
        StringBuilder sb= new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
