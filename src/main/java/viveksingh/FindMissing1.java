package viveksingh;

import java.util.HashSet;

public class FindMissing1 {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1,3,0}));
    }

    public static int missingNumber(int[] nums) {
        int len = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int a : nums) {
            hs.add(a);
        }
        for (int i = 0; i < len + 1; i++) {
            if (!hs.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
