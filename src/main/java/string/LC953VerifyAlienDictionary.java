package string;

public class LC953VerifyAlienDictionary {


    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }


    public static boolean isAlienSorted(String[] words, String order) {
        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                if (order.indexOf(word.charAt(i)) > order.indexOf(word.charAt(i + 1))) {
                    return false;
                }
            }
        }

        return true;
    }
}
