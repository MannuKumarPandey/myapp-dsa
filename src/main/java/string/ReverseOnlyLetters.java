package string;

import java.util.ArrayList;
import java.util.List;

public class ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
    }

    public static String reverseOnlyLetters(String s) {
        List<Integer> hIndex = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                hIndex.add(i);
            }
        }


        String[] words = s.split("-");
        StringBuilder sb = new StringBuilder();
        for (String ss : words) {
            sb.append(ss);
        }
        sb = sb.reverse();
        for (int i = 0; i < hIndex.size(); i++) {
            sb.insert((int)hIndex.get(i), '-');
        }
        return sb.toString();

    }
}
