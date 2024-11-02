package string;

public class VowelSubString {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    public static int maxVowels(String s, int k) {

        int max = 0;
        int resMax = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < k; right++) {
            if (isVowel(s.charAt(right))) {
                max++;
            }
        }

        while (right < s.length()) {
            if (isVowel(s.charAt(left))) {
                max = max - 1;
            }
            left++;

            if (isVowel(s.charAt(right))) {
                max = Math.max(max, max + 1);
            }
            right++;
            resMax = Math.max(resMax, max);
        }
        return resMax;

    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

