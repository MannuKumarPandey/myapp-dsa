package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationsWithOnlyRecusrions {
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
        temp.add(index);
        util(n, k, index + 1, temp);
        temp.remove(temp.size() - 1);
        util(n, k, index + 1, temp);
    }
}

