package sorting;

public class DutchNationalFlagOrSortColors {


    public static void main(String[] args) {
        int[] result = sortColors(new int[]{2, 0, 2, 1, 1, 0});
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    public static int[] sortColors(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = nums.length - 1;
        int i = 0;
        while (one <= two) {

            if (nums[one] == 0) {

                int temp = nums[one];
                nums[one] = nums[zero];
                nums[zero] = temp;

                one += 1;
                zero += 1;

            } else if (nums[one] == 1) {
                one += 1;
            } else {
                int temp = nums[one];
                nums[one] = nums[two];
                nums[two] = temp;
                two -= 1;
            }
        }

        return nums;
    }


}
