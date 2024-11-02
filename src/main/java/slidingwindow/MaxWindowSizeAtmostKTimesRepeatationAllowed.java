package slidingwindow;

import java.util.HashMap;

public class MaxWindowSizeAtmostKTimesRepeatationAllowed {

    public static void main(String[] args) {

        String s = "absdghfgdsahjgflsdgjgfjh";
        int k = 2;

        /*
         * given String me at most k time repeatation allowed wale substring ma max
         * window size kitna hai
         */

        int result = Integer.MIN_VALUE;

        int length = s.length();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put(s.charAt(0), 1);

        int i = 1;

        while (i < length) {
            int j = i;
            int tempResult = 0;
            while (j < length) {
                if (hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j)) <= k) {
                    hm.put(s.charAt(j), hm.get(s.charAt(j)) + 1);
                    tempResult++;
                    j++;
                } else {
                    hm.put(s.charAt(j), 1);
                    tempResult++;
                    j++;
                }
                i = j;
            }

            result = Math.max(result, tempResult);

        }

        System.out.println(result);
    }

}

