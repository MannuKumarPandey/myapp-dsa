package viveksingh;

public class Binarysearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 79;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == key) {
                System.out.println("Key found");
                return;
            } else if (arr[mid] < key) {
                l = mid + 1;//right half me jao
            } else {
                r = mid - 1;//left half me jao
            }
        }

        System.out.println("Key not found");

    }
}
