package hashset;

import java.util.Arrays;
import java.util.HashSet;

public class LC2670 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(distinctDifferenceArray(new int[]{3, 2, 3, 4, 2})));
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] prefix = new int[len];
        HashSet<Integer> hsp = new HashSet<>();

        int[] suffix = new int[len];
        HashSet<Integer> hss = new HashSet<>();

        for (int i = 0; i < len; i++) {

            hsp.add(nums[i]);
            prefix[i] = hsp.size();

            suffix[len - 1 - i] = hss.size();
            hss.add(nums[len - 1 - i]);

        }

        for (int i = 0; i < len; i++) {
            result[i] = prefix[i] - suffix[i];
        }


        return result;

    }
}
