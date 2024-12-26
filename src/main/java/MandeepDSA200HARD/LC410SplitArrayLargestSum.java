package MandeepDSA200HARD;

public class LC410SplitArrayLargestSum {

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public static int splitArray(int[] nums, int k) {

        //max of the array
        int start = Integer.MIN_VALUE;

        //total sum of the array elements
        int end = 0;

        for (int i : nums) {
            end += i;
            start = Math.max(start, i);
        }

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            //mid is acceptable then do it for start to mid-1
            if (acceptable(nums, mid, k)){
                end = mid - 1;
            }
            //if mid is not acceptable then do it for mid+1 to end
            else{
                start = mid + 1;
            }
        }
        return start;
    }


    // kya jo mid value send kiya gya hua hai, us mid value se chote sum ke k
    // sub array ban sakte hai kya :
    //matlab kya jo mid send kiya gya hai wo mid acceptable hai means isase chhote k subarrays
    // ban rahe hai?
    public static boolean acceptable(int[] nums, int mid, int k) {

        int sum = 0;
        for (int i : nums) {
            if (sum + i > mid) {
                sum = 0;
                k--;
            }
            sum += i;
            if (k <= 0) return false;
        }
        return true;
    }
}
