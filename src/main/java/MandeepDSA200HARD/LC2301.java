package MandeepDSA200HARD;

public class LC2301 {

    public static void main(String[] args) {
       // System.out.println(matchReplacement());
    }

    public static boolean f(StringBuilder tempSub, StringBuilder sub, char[][] mappings) {
        for (int i = 0; i < sub.length(); i++) {
            if (tempSub.charAt(i) == sub.charAt(i)) continue;
            if (tempSub.charAt(i) != sub.charAt(i)) {
                char char1 = tempSub.charAt(i);
                char char2 = sub.charAt(i);

                for (char[] map : mappings) {
                    char tchar1 = map[0];
                    char tchar2 = map[1];

                    if (char2 == tchar1 && tchar2 == char1) {
                        sub.insert(i, tchar2);
                    }
                }
            }

        }
        return sub.equals(tempSub);
    }

    public static boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n = s.length();
        StringBuilder subtemp = new StringBuilder(sub);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                StringBuilder tempSub = new StringBuilder(s.substring(i, j));
                if (tempSub.length() == sub.length()) {
                    if (f(tempSub, subtemp, mappings)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}