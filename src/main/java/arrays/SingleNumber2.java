package arrays;

public class SingleNumber2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << (i))) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                res = ((1 << i) | res);
            }
        }
        return res;
    }
}
