package arrays;

public class SmallestSubArraySumGreaterThanAValue {

	public static void main(String[] args) {
		/*
		 * Use the concept of sliding window
		 */
		
		int array[] = new int[] {2,1,4,3,8,4,5,6,7,4,5,9};
		int givenSum = 12;
		int length = array.length;
		int start =0;
		int end = 0;
		int ans = array.length+1;
		int sum =0;
		while(end < length) {
			while(sum <= givenSum && end < length) {
				sum+= array[end];
				end++;
					
			}
			while(sum > givenSum && start < length) {
				ans = Math.min(ans, end-start);
				sum-= array[start];
				start++;
					
			}
		}
		System.out.println(ans);
		
	}

}
