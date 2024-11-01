package arrays;

public class MinimumNoOfJumpsToReachEnd {

	public static int count = 0;
	public static void main(String[] args) {
		int array[] = new int[] {1,3,5,8,9,2,6,7,6,8,9,6,7,1,4,5,6,7,89};
		System.out.println(jump(array, 0, array.length-1));
	}
	
	public static int jump(int array[], int l, int h) {
		if(h<0)
			return -1;
		if(array[l]+l>=h) {
			return count++;
		}
		else{
			count ++;
			jump(array,array[l]+l, h);
		}
		return count;
	}
}
