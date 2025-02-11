package MandeepDSA200Medium;

import java.util.HashMap;
import java.util.Map;

public class LC1726TouplesMultiplication {

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{1, 2, 4, 5, 10}));
    }

    public static int tupleSameProduct(int[] nums) {
        int N = nums.length;
        int res = 0;


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }


        for (int freq : map.values()) {
            if (freq >= 2) {
                res += 4 * freq * (freq - 1); // 4 * nC2 gives the required count
            }
        }

        return res;
    }

}
