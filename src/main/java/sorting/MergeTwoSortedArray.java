package sorting;

public class MergeTwoSortedArray {

    static int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
    static int[] arr2 = new int[]{2, 5, 6};

    public static void main(String[] args) {
        merge(arr1, 3, arr2, 3);

        for (int h : arr1) {
            System.out.print(h + " ");
        }
    }


    public static void merge(int[] arr1, int m, int[] arr2, int n) {

        int lenO = m + n;


        int arrB[] = new int[m];
        for (int i = 0; i < m; i++) {
            arrB[i] = arr1[i];
        }

        int res[] = new int[lenO];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (arrB[i] <= arr2[j]) {
                arr1[k] = arrB[i];
                i++;
            } else {
                arr1[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            arr1[k] = arrB[i];
            i++;
            k++;
        }
        while (j < n) {
            arr1[k] = arr2[j];
            j++;
            k++;
        }


    }
}
