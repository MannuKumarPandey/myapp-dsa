package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumber3 {

    public static void main(String[] args) {

        int[] res = singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        for (int l : res) {
            System.out.print(l + " ");
        }
    }

    public static int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                arrList.add(nums[i]);
                i++;
            } else {
                i = i + 2;
            }
        }
        if (nums[i - 1] != nums[i]) {
            arrList.add(nums[i]);
        }
        int[] res = new int[arrList.size()];
        for (int j = 0; j < arrList.size(); j++) {
            res[j] = arrList.get(j);
        }
        return res;
    }
}

