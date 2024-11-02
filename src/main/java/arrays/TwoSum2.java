package arrays;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));

    }

    public static int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        int len = numbers.length;
        for (int i = 0; i < len-1; i++) {
            res[0] = i+1;

            int start = i + 1;
            int end = len - 1;
            int rem = target - numbers[i];
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (numbers[mid] == rem) {
                    res[1] = mid+1;
                    return res;
                } else if (numbers[mid] < rem) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return res;
    }

}
