package arrays;

public class SetKthBit {
    public static void main(String[] args) {
        System.out.println(setKthBit(10, 2));
    }

    public static int setKthBit(int n, int k) {
        return n | (1 << k);
    }
}
