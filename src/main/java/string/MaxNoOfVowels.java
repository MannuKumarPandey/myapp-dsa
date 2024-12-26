package string;

import java.util.HashMap;

public class MaxNoOfVowels {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    private static boolean isVowel(char ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public static int maxVowels(String s, int k) {

        if (k > s.length()) {
            return 0;
        }

        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //int hashTable[] =
        int vowelCount = 0;
        int length = 0;
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }

            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
            length++;
            if (length > k) {

                map.put(s.charAt(pos), map.get(s.charAt(pos)) - 1);
                if (isVowel(s.charAt(pos))) {
                    vowelCount--;
                }
                pos++;
                length--;
            }
            if (length == k) {
                res = Math.max(res, vowelCount);
            }
            if (res == k) {
                return k;
            }
        }
        return res;
    }
}
