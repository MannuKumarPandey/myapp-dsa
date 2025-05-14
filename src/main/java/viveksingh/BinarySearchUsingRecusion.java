package viveksingh;

public class BinarySearchUsingRecusion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 9;

        int l = 0;
        int r = arr.length - 1;
        int index = binarySearch(arr, key, l, r);
        if (index == -1) {
            System.out.println("Element was not found.");
        } else {
            System.out.println("element found at index : " + index);
        }

    }

    public static int binarySearch(int arr[], int key, int l, int r) {
        //base condition
        if(l > r){
            return -1;
        }
        //operational condition
        int mid = (l + r) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            //right half ke liye recursive call
            return binarySearch(arr, key, mid + 1, r);//right half me jao
        } else {
            //left half ke liye recursive call
            return binarySearch(arr, key, l, mid - 1);//left half me jao
        }
    }
}
