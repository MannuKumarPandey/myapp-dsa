package arrays;

public class MedianOfTwoSortedArrayOfAnySize {

	public static void main(String[] args) {

		int array1[] = new int[] { 1, 4, 6, 9, 11, 40 };
		int array2[] = new int[] { 8, 10, 76, 99, 110 };

		int totalLength = array1.length + array2.length;
		int resultantArray[] = new int[totalLength];
		int midElement = totalLength / 2;
		int counter = 0;
		int i = 0;
		int j = 0;
		int p = 0;

		while (i < array1.length || j < array2.length) {
			if (midElement % 2 == 0 && counter == midElement + 1) {
				System.out.println((resultantArray[counter - 2] + resultantArray[counter - 1]) / 2);
				return;
			}
			if (midElement % 2 != 0 && counter == midElement + 1) {
				System.out.println(resultantArray[counter - 1]);
				return;
			}
			if (array1[i] < array2[j]) {
				resultantArray[p] = array1[i];
				counter++;
				p++;
				i++;
			} else if (array1[i] > array2[j]) {
				resultantArray[p] = array2[j];
				counter++;
				j++;
				p++;
			} else {
				resultantArray[p] = array2[j];
				counter++;
				p++;
			}
		}
		while (i < array1.length) {
			resultantArray[p] = array1[i];
			p++;
			i++;
		}
		while (j < array2.length) {
			resultantArray[p] = array2[j];
			p++;
			j++;
		}
	}

}
