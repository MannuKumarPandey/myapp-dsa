package arrays;

public class ChocolateDivideProblem {

    //Failing with some cases

    public static void main(String[] args) {

        int[] sweetness = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int friends = 5;

        int totalSweetnes = 0;
        for (int i : sweetness) {
            totalSweetnes += i; // 45
        }


        int totalCount = friends + 1; // 6

        int result = Integer.MAX_VALUE;

        int divideDetails = totalSweetnes / totalCount; //7

        for (int i = 0; i < sweetness.length; i++) {
            int tempSum = 0;
            int p = i;
            while (tempSum < divideDetails) {
                tempSum += sweetness[p++];
            }

            tempSum = tempSum - sweetness[p - 1];
            result = Math.min(tempSum, result);
            i = p;
        }

        System.out.println(result);

    }
}