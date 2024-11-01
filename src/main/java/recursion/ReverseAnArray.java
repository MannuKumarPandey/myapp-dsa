package recursion;

public class ReverseAnArray {

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int reversedArray[] = reverseArray(0, array.length - 1, array);
		for (int h : reversedArray) {
			System.out.print(h + " ");
		}
	}

	public static int[] reverseArray(int i, int j, int[] array) {
		if (i > j) {
			return array;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array = reverseArray(i + 1, j - 1, array);
	}
}
