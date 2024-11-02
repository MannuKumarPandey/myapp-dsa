package string;

public class StringBuilderChanges {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef");
        int sIndex = sb.indexOf("abc");
        sb.delete(sIndex, sIndex+3);
        System.out.println(sb);
        System.out.println(sb.indexOf("abf"));

        System.out.println(minExtraChar("leetscode", new String[] {"leet","code","leetcode"}));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        StringBuilder sb = new StringBuilder(s);

        for(String h: dictionary){
            if(sb.indexOf(h) != -1){
                int sIndex = sb.indexOf(h);
                sb.delete(sIndex, sIndex+h.length());
            }
        }
        return sb.length();
    }
}
