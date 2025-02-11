package Dhruveel;

import java.util.Arrays;

public class LC1636 {

    public static void main(String[] args) {
       // System.out.println(Arrays.toString(frequencySort(new int[]{1,1,2,2,2,3})));
    }

   /* public static int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int num : nums) {
            count[num + 100]++;
        }

        Arrays.sort(nums, (a, b) -> {

            if (count[(int)a + 100] == count[(int)b + 100]) {
                return (int)b - (int)a;
            }
            return count[(int)a + 100] - count[(int)b + 100];
        });

        return Arrays.stream(sortedNums).mapToInt(Integer::intValue).toArray();
    }*/
}
