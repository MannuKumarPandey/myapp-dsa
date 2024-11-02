package math;

public class NToPowerE {
    public static void main(String[] args) {
        int n = 2;
        int e = 10;

        boolean negativeFlag = false;
        if (e < 0) {
            negativeFlag = true;
            e = -1 * e;
        }

        int result = 1;
        result = power(result, n, e);

        if (negativeFlag) {
            System.out.println(1 / result);

        } else {
            System.out.println(result);
        }
    }

    private static int power(int result, int n, int e) {

        while (e > 0) {
            if (e % 2 != 0) {
                result = result * n;
            }
            n = n * n;
            e = e / 2;

        }

        return result;

    }

}

