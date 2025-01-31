package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class LC697 {


    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    public static int findShortestSubArray(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a : nums) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }

        HashSet<Integer> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            max = Math.max(max, e.getValue());
        }

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() == max) {
                hs.add(e.getKey());
            }
        }
        int result = Integer.MAX_VALUE;
        for (int a : hs) {
            int f = -1;
            int s = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] == a && f == -1) {
                    f = i;
                    s = i;
                } else if(nums[i] == a){
                    s = i;
                }
            }
            result = Math.min(result, s - f+1);
        }

        return result;

    }
}
