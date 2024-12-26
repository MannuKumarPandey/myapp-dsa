package sorting;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 5, 10, 16, 29};
        int[] arr2 = new int[]{2, 3, 9, 11, 14};

        int len1 = arr1.length;
        int len2 = arr2.length;
        int lenO = len1 + len2;

        int[] res = new int[lenO];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            res[k] = arr1[i];
            i++;
            k++;
        }
        while (j < len2) {
            res[k] = arr1[j];
            j++;
            k++;
        }
        for (int llk : res) {
            System.out.print(llk + " ");
        }

    }

}

