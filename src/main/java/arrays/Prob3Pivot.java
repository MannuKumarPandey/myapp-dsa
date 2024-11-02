package arrays;

public class Prob3Pivot {
    public static void main(String[] args) {

        // left subbrayy sum == right sum array (Except that particular array)

        int[] arr = new int[]{1, 7, 3, 6, 5, 6};

        int len = arr.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        prefix[0] = arr[0];
        suffix[len - 1] = arr[len - 1];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = len - 1; i > 0; i--) {
            suffix[i - 1] = suffix[i] + arr[i];
        }

        for (int i = 0; i < len; i++) {
            if (prefix[i] == suffix[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    // Now compress it in O(n) space complexity: use only one variable as total sum:

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

}
