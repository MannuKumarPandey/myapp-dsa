package MandeepDSA200Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC2342MaxSumOfPairs {

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
    }


    public static int maximumSum(int[] nums) {
        int result = -1;
        int len = nums.length;
        int[] digitSum = new int[len];
        for (int i = 0; i < len; i++) {
            digitSum[i] = digitSumCal(nums[i]);
        }

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (hm.containsKey(digitSum[i])) {
                ArrayList<Integer> temp = hm.get(digitSum[i]);
                temp.add(nums[i]);
                hm.put(digitSum[i], temp);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(nums[i]);
                hm.put(digitSum[i], al);
            }
        }

        int mapSize = hm.size();
        for (Map.Entry<Integer, ArrayList<Integer>> a : hm.entrySet()) {
            if (a.getValue().size() > 1) {
                ArrayList<Integer> aa = a.getValue();
                Collections.sort(aa);
                int tempSize = aa.size();
                result = Math.max(result, aa.get(tempSize - 1) + aa.get( tempSize- 2));
            }
        }

        return result;

    }

    public static int digitSumCal(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num = num / 10;
        }
        return digitSum;
    }
}
