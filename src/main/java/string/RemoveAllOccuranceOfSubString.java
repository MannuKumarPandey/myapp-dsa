package string;

public class RemoveAllOccuranceOfSubString {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }
    public static String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            int i = s.indexOf(part);
            s = s.substring(0,i)+s.substring(part.length()+i);
        }

        return s;
    }

}
