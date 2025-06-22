package sorting;

public class A_MergeSort {
    public static void main(String[] args) {
        int[] res = new int[]{4, 1, 5, 2, 8, 15, 80};
        mergeSortC(res, 0, 6);

        for (int ll : res) {
            System.out.print(ll + " ");
        }
    }


    public static void mergeSortC(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;//taki ham middle se tod sake

        mergeSortC(arr, start, mid); //divide
        mergeSortC(arr, mid + 1, end); //divide
        merge(arr, start, mid, end); //merge


    }

    public static void merge(int[] arr, int start, int mid, int end) {

        int len1 = mid - start + 1;
        int len2 = end - mid;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        for (int i = 0; i < len1; i++) {
            arr1[i] = arr[start + i];
        }

        for (int j = 0; j < len2; j++) {
            arr2[j] = arr[mid + 1 + j];
        }


        int i = 0;
        int j = 0;
        int k = start;

        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }


        while (i < len1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

}
