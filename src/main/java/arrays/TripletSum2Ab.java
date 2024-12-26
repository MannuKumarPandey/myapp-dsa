package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum2Ab {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());

    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return utilTriplets(nums);
    }

    private static List<List<Integer>> utilTriplets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {

                int start = i + 1;
                int end = n - 1;
                int remaining = -nums[i]; // 0-nums[i]

                while (start < end) {
                    if (remaining == (nums[start] + nums[end])) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);

                        res.add(temp);

                        /*key point: agar kisi do values and i ke sum se result mile to bhi ya  sum target se bada ho ya chhota ho har case me
                            same values ko skip karte rahna hai.*/

                        while (start < end && nums[start] == nums[start + 1]) {  //same start ke values ko ab skip karna hai
                            start++;
                        }
                        start++;

                        while (start < end && nums[end] == nums[start - 1]) { //same end ke values ko skip karna hai
                            end--;
                        }
                        end--;
                    } else if (remaining > nums[start] + nums[end]) { //yha start end jodkar bhi remaining se chhota hai isliye start ko agge badhaye
                        while (start < end && nums[start] == nums[start + 1]){ //jab is start se nahi mila matlab ese same start ke values bhi nahi denge result
                            start++;
                        }
                        start++;
                    } else {  //yha start end jodkar remaining se bada hai isliye end ko pichhe badhaye
                        while (start < end && nums[end] == nums[start - 1]) { //jab is end se nahi mila matlab ese same end ke values bhi nahi denge result
                            end--;
                        }
                        end--;
                    }
                }
            }
        }
        return res;
    }
}

