package MandeepDSA200Medium;

public class StringMultiply {

    public String multiply(String nums1, String nums2) {
        int n = nums1.length();
        int m = nums2.length();

        int[] arr = new int[n + m];


        for (int i = n - 1; i >= 0; i--) {
            int digit1 = nums1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int digit2 = nums2.charAt(j) - '0';

                int product = digit1 * digit2;


                int ansToStore = product % 10;
                int position = i + j + 1;

                int carry = product / 10;
                int carryPoisition = i + j;

                arr[position] += ansToStore;
                arr[carryPoisition] += carry;


            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (arr[i] != 0) {
            i++;
        }

        for (int j = i; j < arr.length; j++) {
            sb.append(arr[j]);
        }

        return sb.toString();
    }
}