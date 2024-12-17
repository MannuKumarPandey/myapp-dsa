package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {

        int jyadaSeJyadaKitnaDurJaSakteHai = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > jyadaSeJyadaKitnaDurJaSakteHai) { // matlab jyadaSeJyadaKitnaDurJaSakteHai se aage hai i aur ham i tak hi nahi pahuch sakte hai
                return false;
            }
            jyadaSeJyadaKitnaDurJaSakteHai = Math.max(jyadaSeJyadaKitnaDurJaSakteHai, i + nums[i]); // Update the farthest reachable index
            if (jyadaSeJyadaKitnaDurJaSakteHai >= nums.length - 1) { // If the last index is reachable
                return true;
            }
        }
        return false;
    }
}
