package MandeepDSA200Medium;

public class LC152MaximumProductSubArray {


    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {

        //yha prefix product array and suffix product banakar bhi kar sakte hai
        //but jis index par 0 mile uske product ko zero rakh lo
        //but factor ko 1 se reinitialize kare
        //wo approach O(n) time complexity and O(n) space complexity me kar dega.


        double leftProduct = 1;
        double rightProduct = 1;
        double ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (leftProduct == 0) {
                leftProduct = 1;
            }
            if (rightProduct == 0) {
                rightProduct = 1;
            }

            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[nums.length - i - 1];
            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return (int) ans;
    }
}
