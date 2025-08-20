package bitmanipulation;

public class InbuiltMethodsToCountBits {


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.bitCount(15));
        System.out.println(Integer.highestOneBit(15));
        System.out.println(Integer.lowestOneBit(15));
    }
}
