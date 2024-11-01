package arrays;

public class ThreeWayPartitioning {

	public static void main(String[] args) {

		int array[] = new int[] { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };
		int n = array.length;
		int lowValue = 10;
		int highValue = 20;

		int start = 0;
		int end = array.length - 1;

		for (int i = 0; i <= end;) {
			if (array[i] < lowValue) {
				int temp = array[start];
				array[start] = array[i];
				array[i] = temp;
				start++;
				i++;
			} else if (array[i] > highValue) {
				int temp = array[end];
				array[end] = array[i];
				array[i] = temp;
				end--;

			} else
				i++;
		}

		for (int g : array) {
			System.out.print(g + " ");
		}
	}
}
