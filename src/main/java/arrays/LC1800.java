package arrays;

public class LC1800 {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }

    public static int maxAscendingSum(int[] nums) {

        int i = 0;
        int result = 0;

        int len = nums.length;
        while (i < len - 1) {
            int tempRes = 0;
            while (i < len - 1) {
                if (nums[i + 1] > nums[i]) {
                    tempRes += nums[i];
                    result = Math.max(result, tempRes);
                    i++;
                } else {
                    break;
                }
            }
            tempRes += nums[i];
            result = Math.max(result, tempRes);
            if (i == len - 2 && nums[len - 1] > nums[len - 2]) {
                tempRes += nums[len - 1];
                result = Math.max(result, tempRes);
            }
            i++;
        }
        return result;
    }
}
