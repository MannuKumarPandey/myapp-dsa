package arrays;

public class RangeSumQueryImmutable {
    int prefixSum[];

    public RangeSumQueryImmutable(int[] nums) {
        prefixSum = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = result + nums[i];
            result = result + nums[i];
        }
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable r = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(r.sumRange(0, 2));
        System.out.println(r.sumRange(2, 5));
        System.out.println(r.sumRange(0, 5));
    }

    public int sumRange(int left, int right) {
        if (left - 1 < 0) {
            return prefixSum[right];
        } else {
            return prefixSum[right] - prefixSum[left - 1];
        }
    }
}
