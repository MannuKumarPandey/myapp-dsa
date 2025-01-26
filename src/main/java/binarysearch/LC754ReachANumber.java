package binarysearch;

public class LC754ReachANumber {

    public static void main(String[] args) {
        System.out.println(reachNumber(7));
    }


    public static int reachNumber(int target) {
        target = Math.abs(target); // Work with positive target
        int sum = 0;
        int steps = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            steps++;
            sum += steps;
        }

        return steps;
    }
}
