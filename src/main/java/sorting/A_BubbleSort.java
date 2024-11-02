package sorting;

public class A_BubbleSort {
    public static void main(String[] args) {
        int[] h = bubbleSort(new int[]{13, 46, 24, 52, 20, 9});
        for (int k : h) {
            System.out.print(k + " ");
        }
    }

    public static int[] bubbleSort(int[] arr) {
        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = 0; j < arrLength - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap Here
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
