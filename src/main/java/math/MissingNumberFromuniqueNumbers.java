package math;

public class MissingNumberFromuniqueNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 3, 1, 4, 7, 6, 8};

        int result = arr.length;

        for (int i = 0; i < arr.length; i++) {
            result = result ^ i ^ arr[i];
        }

        System.out.println(result);
    }

}

