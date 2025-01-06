package backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPowerSet {

    public static void main(String[] args) {

        String s = "abc";


        List<List<String>> res = subsets(s);
        System.out.println("total possible combinations ::::" + res.size());
        System.out.println(res.toString());
    }

    public static List<List<String>> subsets(String s) {
        List<List<String>> ans = new ArrayList<>();
        subsetHelper(s, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void subsetHelper(String s, int i, List<List<String>> ans, List<String> tempAns) {

        // what is missing here ? why I am not able to get the other combinations ?


        if (i == s.length()) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }


        // If we Include the current element
            tempAns.add(Character.toString(s.charAt(i)));
            subsetHelper(s, i + 1, ans, tempAns);
            tempAns.remove(tempAns.size() - 1); // Backtrack
            subsetHelper(s, i + 1, ans, tempAns);//piche jane ki jarurat nahi hai yha
    }
}

