package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KOrFourSumTarget {


    static int len = 0;

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).toString());
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8).toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        len = nums.length;
        return kSum(nums, target, 4, 0);
    }

    private static ArrayList<List<Integer>> kSum(int nums[], int target, int k, int index) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        if (index >= len) return res;


        if (k == 2) {
            int l = index;
            int r = len - 1;

            while (l < r) {

                if (target == nums[l] + nums[r]) {

                    List<Integer> list = new ArrayList<Integer>();

                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;

                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }


        } else {

            for (int i = index; i < len - k + 1; i++) {

                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);

                if (temp != null) {

                    for (List<Integer> item : temp) {
                        item.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }

                while (i < len - 1 && nums[i] == nums[i + 1]) i++;


            }
        }

        return res;
    }

}
