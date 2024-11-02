package string;

public class PrintAllDigitsOfAStringInRecursion {
    public static void main(String[] args) {
        int s = 292434;
        printDigits(s);
    }

    private static int printDigits(int s) {

        if (s == 0) {
            return 0;
        }

        System.out.print(s % 10 + " ");
        return printDigits(s / 10);

    }

}
