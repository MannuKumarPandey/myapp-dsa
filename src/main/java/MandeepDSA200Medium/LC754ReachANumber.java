package MandeepDSA200Medium;

public class LC754ReachANumber {

    public static void main(String[] args) {
        System.out.println(reachNumber(2));
    }

    public static int reachNumber(int target) {
        if (target < 0) {
            target = -1 * target;
        }


        int start = 0;
        int end = target;

        int n = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            if (sum == target)
                return mid;
            if (sum > target) {
                n = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }


        long sum = (long) n * (n + 1) / 2;

        while ((sum - target) % 2 == 1) {
            n++;
            sum += n;
        }


        return n;
    }
}
