package MandeepDSA200Medium;

public class LC400NthDigit {

    public static void main(String[] args) {
        System.out.println(findNthDigit(11));
    }

    public static int findNthDigit(int n) {

        int rangeStart = 1;
        int totalDigitCount = 1;
        long totalNumbersInRange = 9;

        while (n > totalDigitCount * totalNumbersInRange) {
            n = (int)(n- (totalDigitCount * totalNumbersInRange));
            totalDigitCount++;
            rangeStart *= 10;
            totalNumbersInRange *= 10;
        }

        long number = rangeStart + (n - 1) / totalDigitCount;

        int digitIndex = (int) ((n - 1) % totalDigitCount);
        return Character.getNumericValue(Long.toString(number).charAt(digitIndex));
    }
}
