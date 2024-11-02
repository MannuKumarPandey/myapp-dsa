package arrays;

public class SubArrayWithSumZero {

	public static void main(String[] args) {
		
		// in O(n2)  try to optimize it.

		int array[] = new int[] {1,4,2,3,-4,24,5,4,6};
		boolean status = false;
		
		int n = array.length;
		int sum =0;
		// It can be solved by Sliding window approach which will do teh task in O(n)
		for(int i = 0; i< n-1;i++) {
			for(int j = i; j< n-1;j++) {
				if(sum + array[j] == 0) {
					status = true;
					break;
				}
				else {
					sum = sum + array[j];
				}
			}
			sum = 0;
		}
		System.out.println(status);
		
	}
}
