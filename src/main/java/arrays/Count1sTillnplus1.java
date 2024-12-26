package arrays;

public class Count1sTillnplus1 {
    public static void main(String[] args) {
        int n = 5;
        int[] result = new int[n + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = count1s(i);
        }

        for (int kk : result) {
            System.out.print(kk + " ");
        }
    }

    private static int count1s(int num) {

        int mask = 1;
        int count = 0;
        for (int i = 0; i < 16; i++) {
            if ((num & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }

        return count;
    }

}
