package arrays;

public class ReverseAnArrayRotation {
    public static void main(String[] args) {
        int[] res = rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

        for (int g : res) {
            System.out.print(g + " ");
        }
        System.out.println();
    }

    public static int[] rotate(int[] nums, int k) {
        int arrLen = nums.length;
        nums = rorateI(nums, arrLen - k, arrLen - 1);
        nums = rorateI(nums, 0, arrLen - k - 1);
        nums = rorateI(nums, 0, arrLen - 1);
        return nums;
    }

    private static int[] rorateI(int[] nums, int i, int j) {
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}
