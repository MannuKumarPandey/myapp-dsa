package slidingwindow;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LC1493 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
    }

    public static int longestSubarray(int[] nums) {

        int res = Integer.MIN_VALUE;

        int len = nums.length;
        int i = 0;
        while (i < len) {

            LinkedHashSet<Integer> hs = new LinkedHashSet<>();
            int j = i;
            while (j < len) {
                if (nums[j] == 0 && hs.contains(nums[j])) {
                    res = Math.max(res, j - i-1);
                    while(nums[i]!=0){
                        i++;
                    }
                    break;
                } else {
                    hs.add(nums[j]);
                    j++;
                }
            }
            if (j == len) {
                res = Math.max(res, j - i-1);
                break;
            }
            i++;

        }

        return res;

    }
}