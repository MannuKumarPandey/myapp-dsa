package arrays;

public class GcdOfAnArray {

    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{15, 25}));
    }

    public static int findGCD(int[] nums) {
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = gcdFun(gcd, nums[i]);
        }
        return gcd;
    }

    private static int gcdFun(int a, int b) {
        if (a == 0) return b;
        return gcdFun(b % a, a);
    }
}
