package math;

public class GCDOfAnArray {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 36, 9, 6, 8};
        int res = GCD(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            res = GCD(res, arr[i]);
        }
        System.out.println(res);
    }

    // Eculedian Algorithm to subtract the a from b and continues till b because 0
    public static int GCD(int a, int b) {
        if (b % a == 0) {
            return a;
        }

        return GCD(b % a, a);
    }

}

