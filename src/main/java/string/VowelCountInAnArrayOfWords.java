package string;

public class VowelCountInAnArrayOfWords {

    public static void main(String[] args) {

        String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
        int[][] query = new int[][]{{0, 4}, {1, 2}, {2, 4}};

        int[] validStrings = new int[words.length];
        for (int i = 0; i < validStrings.length; i++) {
            validStrings[i] = isValid(words[i]);
        }

        int[] prefix = new int[validStrings.length];
        prefix[0] = validStrings[0];
        for (int i = 1; i < validStrings.length; i++) {
            prefix[i] = prefix[i - 1] + validStrings[i];
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {

            if (query[i][0] == 0) {
                result[i] = prefix[query[i][1]];
            } else {
                result[i] = prefix[query[i][1]] - prefix[query[i][0] - 1];
            }
        }

        for (int k : result) {
            System.out.print(k + " ");

        }

    }

    private static int isValid(String string) {

        return isVowel(string.charAt(0)) && isVowel(string.charAt(string.length() - 1)) == true ? 1 : 0;
    }

    private static boolean isVowel(char charAt) {

        return charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u';

    }

}

