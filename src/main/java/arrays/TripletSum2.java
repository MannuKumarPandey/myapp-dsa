package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum2 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}).toString());
    }



    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        return utilTriplets(nums);

    }

    private static List<List<Integer>> utilTriplets(int nums[]) {

        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {

                int start = i + 1;
                int end = n - 1;
                int remaining = 0 - nums[i];

                while (start < end) {

                    if (remaining == (nums[start] + nums[end])) {

                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);

                        res.add(temp);
                        while (start < end && nums[start] == nums[start + 1])
                            start++;
                        start++;

                        while (start < end && nums[end] == nums[start - 1])
                            end--;
                        end--;
                    } else if (remaining > nums[start] + nums[end]) {
                        while (start < end && nums[start] == nums[start + 1])
                            start++;
                        start++;
                    } else {
                        while (start < end && nums[end] == nums[start - 1])
                            end--;
                        end--;
                    }

                }
            }
        }
        return res;
    }

}

