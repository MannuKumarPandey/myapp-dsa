package arrays;

public class FindMaxAndMinInArray {
	public static void main(String[] args) {
		int array[] = new int[] {2,1,3,4,5,2,7,6,5,4,45};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		//in O(n) time complexity
		//if I could have been gone for sorting then atleast nlogn was required for the
		//best sorting algorithm
		for(int g: array) {
			if(g<min) {
				min = g;
			}
			if(g > max) {
				max = g;
			}
		}
		System.out.println("Min ::: "+ min);
		System.out.println("Max:::::" + max);
	}
}
