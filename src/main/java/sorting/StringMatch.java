package sorting;

public class StringMatch {
    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[] {"pa","papa","ma","mama"}));
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {

                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPrefixAndSuffix(String left, String right) {
        int m = right.length() - left.length();
        int startIndex = right.indexOf(left) ;
        int endIndex = right.lastIndexOf(left);
        return startIndex == 0 && endIndex == m;
    }
}

