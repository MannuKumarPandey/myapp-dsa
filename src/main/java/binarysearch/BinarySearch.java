package binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(x, 0, 10, 9));
    }

    public static boolean binarySearch(int x[], int i, int j, int key) {
        int mid = (i + j) / 2;
        if (i >= j) {
            return false;
        }
        if (x[mid] == key) {
            return true;
        }

        if (key < x[mid]) {
            return binarySearch(x, i, mid - 1, key);
        } else {
            return binarySearch(x, mid + 1, j, key);
        }
    }
}
