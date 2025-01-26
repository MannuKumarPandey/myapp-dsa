package bitmanipulation;

public class LC3095 {

    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{2, 1, 8}, 10));
    }


    public static int minimumSubarrayLength(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int xorTemp = 0;
            int cc = 0;
            for (int j = i; j < len; j++) {
                if ((xorTemp ^ nums[j]) >= k) {
                    cc++;
                    result = Math.min(cc, result);
                    break;
                } else {
                    cc++;
                    xorTemp = xorTemp ^ nums[j];
                }
            }
        }
        return result;
    }
}
