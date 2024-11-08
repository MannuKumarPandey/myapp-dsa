package prefixsuffixoperations;

public class RangeSumQueryMutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray {

    int prefixSum[];
    int arr[];

    public NumArray(int[] nums) {
        arr = new int[nums.length];
        arr = nums;

        prefixSum = new int[nums.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    public void update(int index, int val) {
        int prevV = arr[index];
        arr[index] = val;
        int diff = val - prevV;
        for (int i = index; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i] + diff;
        }
    }

    public int sumRange(int left, int right) {

        if (left == 0) {
            return prefixSum[right];
        }

        return prefixSum[right] - prefixSum[left - 1];
    }
}