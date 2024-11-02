package arrays;

public class ArrayWithDuplicates1Single {

    public static void main(String[] args) {
        System.out.println(getSingle(new int[]{2, 2, 1}));

    }

    public static int getSingle(int arr[]) {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }

        return result;
    }
}
