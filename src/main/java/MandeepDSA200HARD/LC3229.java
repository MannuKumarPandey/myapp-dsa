package MandeepDSA200HARD;

public class LC3229 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{3, 5, 1, 2}, new int[]{4, 6, 2, 4}));

       // System.out.println(minimumOperations(new int[]{1, 3, 2}, new int[]{2, 1, 4}));
    }
    public static long minimumOperations(int[] a, int[] t) {
        int n = a.length, previousGap = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.max(t[i] - a[i] - previousGap, 0);
            previousGap = t[i] - a[i];
        }

        return ans + Math.max(-previousGap, 0);

    }
}
