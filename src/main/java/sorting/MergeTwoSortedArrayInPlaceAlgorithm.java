package sorting;

public class MergeTwoSortedArrayInPlaceAlgorithm {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 5, 9};
        int[] arr2 = new int[]{2, 3, 6};

        int len1 = arr1.length;
        int len2 = arr2.length;

        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i++;

            } else {
                j++;
            }
        }
        if (i < len1 - 1 && arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;

        }

        if (j < len2 - 1 && arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;

        }

        for (int pp : arr1) {
            System.out.print(pp + " ");
        }
        for (int pp : arr2) {
            System.out.print(pp + " ");
        }

    }

}
