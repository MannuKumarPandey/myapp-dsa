package arrays;

public class Segregate01fromArray {

	public static void main(String[] args) {
		sortZeroOneArrayByTwoPointers();
	}

	public static void sortZeroOneArrayByTwoPointers() {

		// By counting zeros and ones in an given array
		int array[] = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 0 };
		int i = 0;
		int j = array.length - 1;

		while (i < j) {

			while (array[j] == 1 && i < j) {
				j--;
			}

			while (array[i] == 0 && i < j) {
				i++;
			}

			if (i < j) {
				array[i] = 0;
				array[j] = 1;
				i++;
				j--;
			}
		}
		for (int h : array) {
			System.out.print(h + " ");
		}

	}

	public static void sortZeroOneArray() {

		// By counting zeros and ones in an given array

		int array[] = new int[] { 0, 1, 0, 1, 0, 1, 1, 1, 0 };
		// count the number of 0s present in an array ,
		// so number of the 1s would be array.length-number of 0.
		// then fill the array with 0 and 1 in the same way
		int zeroCounter = 0;

		for (int g : array) {
			if (g == 0) {
				zeroCounter++;
			}
		}
		int oneCounter = array.length - zeroCounter;
		for (int i = 0; i < zeroCounter; i++) {
			array[i] = 0;
		}
		for (int j = zeroCounter; j < array.length; j++) {
			array[j] = 1;
		}
		for (int h : array) {
			System.out.print(h + " ");
		}

	}
}
