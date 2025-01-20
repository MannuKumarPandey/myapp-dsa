package slidingwindow;

public class LC560SubArraySumEqualsToK {


    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,-1,0}, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        int curSum = 0;
        for (int i = 0; i < len; i++) {
            int j = i;
            curSum = 0;
            while (j < len) {
                curSum += nums[j];
                if (curSum == k) {
                    result++;
                }
                j++;
            }
        }
        return result;
    }
}
