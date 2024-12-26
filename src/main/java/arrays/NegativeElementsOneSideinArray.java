package arrays;

public class NegativeElementsOneSideinArray {

	public static void main(String[] args) {
// I am considering that order of the negative and positive elements are not maintained.
		int array[] = new int[] {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		int i=0; 
		int j = array.length-1;
		while(i<=j) {
			while(array[i]<0) {
				i++;
			}
			while(array[j]>0) {
				j--;
			}
			if(i<j) {
				int temp = array[i];
				array[i]  = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		
		for(int h: array) {
			System.out.print(h+" ");
		}
		System.out.println();
	}

}
