package MandeepDSA200HARD;

import java.util.HashSet;

public class LC2354ExcellentPairs {


    public static void main(String[] args) {
        System.out.println(countExcellentPairs(new int[]{1, 2, 3, 1}, 3));
    }

    public static long countExcellentPairs(int[] nums, int k) {
        HashSet<String> hs = new HashSet<>();

        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (f(nums[i], nums[j], k, hs)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean f(int a, int b, int k, HashSet<String> hs) {
        if(hs.contains(a+"-"+b)){
            return false;
        }


        String aa = Integer.toBinaryString(a&b);
        String bb = Integer.toBinaryString(a|b);
        int c1 = 0;
        for (int i = 0; i < aa.length(); i++) {
            if (aa.charAt(i) == '1') {
                c1++;
            }
        }
        int c2 = 0;
        for (int i = 0; i < bb.length(); i++) {
            if (bb.charAt(i) == '1') {
                c2++;
            }
        }

        if (c1+c2 < k) {
            return false;
        }
        hs.add(a+"-"+b);
        return true;


    }
}