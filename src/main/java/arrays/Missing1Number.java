package arrays;

public class Missing1Number {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            result = result ^ i;
        }
        return result;
    }
}
