package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationsRecursionPlusLoop {
    private static List<List<Integer>> res;

    public static void main(String[] args) {
        System.out.println("Total combinations ::::::: " + combine(4, 2).size());
        System.out.println(combine(4, 3).toString());
    }

    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        util(n + 1, k, 1, new ArrayList<>());
        return res;
    }

    private static void util(int n, int k, int index, ArrayList<Integer> temp) {
        if (index > n || temp.size() > k) {
            return;
        }
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < n; i++) {  // isake badale me mai removal ke bad fir se ek recursive call kar sakta hu
            temp.add(i);
            util(n, k, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}


// How should we tackle [2,4] and [4,2] as same entry?

