package sorting;

public class A_SelectionSort {
    public static void main(String[] args) {

        int[] h = selectionSort(new int[]{13, 46, 24, 52, 20, 9});
        for (int k : h) {
            System.out.print(k + " ");
        }
    }

    public static int[] selectionSort(int[] arr) {
        int arrLength = arr.length;
        for (int i = 0; i <= arrLength - 2; i++) {
            // Select the minimum
            int min = i;
            for (int j = i; j < arrLength; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap Here
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
