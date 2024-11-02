package arrays;

public class MinSwap {
    public static void main(String[] args) {
        System.out.println(minimumSteps("101"));
    }

    public static long minimumSteps(String s) {
        char[] arr = s.toCharArray();
        long result = 0;

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            while (arr[i] != '1') {
                i++;
            }
            while (arr[j] != '0') {
                j--;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            result++;
            i++;
            j--;
        }

        return result;
    }

}
