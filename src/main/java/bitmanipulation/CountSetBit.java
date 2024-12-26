package bitmanipulation;

public class CountSetBit {

    public static void main(String[] args) {
        int[] res = countBits(16);
        for (int l : res) {
            System.out.println(l);
        }

    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = getBitSetNo(i);
        }
        return res;
    }

    public static int getBitSetNo(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) > 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }
}

