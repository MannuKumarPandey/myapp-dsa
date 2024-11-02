package arrays;

public class NosRepeatedThriceOneTwoTimeFindThat {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{2, 2, 3, 2, 3, 3, 7}));
    }

    public static int findDuplicate(int[] arr) {

        int mask = 1;
        int result = 0;

        for (int i = 0; i < 6; i++) {
            int tempCount = 0;
            for (int j = 0; j < arr.length; j++) {

                if ((arr[j] & 1 << i) != 0) {
                    tempCount++;
                }
            }

            if (tempCount % 3 != 0) {
                result = (1 << i) | result;
            }
        }

        return result;

    }

}

