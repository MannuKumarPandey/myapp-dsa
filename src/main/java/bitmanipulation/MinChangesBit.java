package bitmanipulation;

class MinChangesBit {

    public static void main(String[] args) {
        System.out.println(minChanges(13, 4));
        String s = String.valueOf(1);
    }

    public static int minChanges(int n, int k) {
        // n se k banana hai
        if ((n | k) != n) {
            return -1;
        }

        int diff = n ^ k;
        int mask = 1;
        int res = 0;

        for (int i = 1; i < 17; i++) {
            if ((diff & mask) == mask) {
                res++;
            }
            mask = mask << 1;
        }

        return res;
    }
}
