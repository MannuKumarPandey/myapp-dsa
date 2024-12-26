package arrays;

public class TripletSumToaGivenValue {

	public static void main(String[] args) {
		int array[] = new int[] {3,2,1,8,3,4,6,2,3,8,5,6,-3};
		int givenSum = 12;
		
		triplet(array, givenSum, 0, 2);
		
	}
	public static void triplet (int array[] , int givenSum, int first, int last) {
		if (last==array.length) {
			return;
		}
		
		int sum =0;
		for(int i=first; i<=last; i++) {
			sum+=array[i];
		}
		
		if(givenSum== sum) {
			System.out.println("{ "+ array[first]+" "+ array[first+1]+" "+ array[last]+" }");
		}
		triplet(array, givenSum, first+1, last+1);
		
		
	}

}
