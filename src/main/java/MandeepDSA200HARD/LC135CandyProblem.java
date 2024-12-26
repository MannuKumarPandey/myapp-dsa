package MandeepDSA200HARD;

import java.util.Arrays;

public class LC135CandyProblem {

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));
    }

    public static int candy(int[] ratings) {
        int result = 0;
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i]++;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i]++;
            }
        }

        for (int h : candies) {
            result += h;
        }


        return result;
    }
}
