package arrays;

public class CyclicallyRotateAnArrayByOne {
	public static void main(String[] args) {

		//Store last element in a variable 
		//shift all the others elements by one position
		//keep last element at first position
		
		int array[] = new int[] {1,2,3,4,5,6,7,8,9,10};
		int lastElement = array[array.length-1];
		for(int i = array.length-1; i>0;i--) {
			array[i]= array[i-1];
		}
		array[0] = lastElement;
		for(int h: array) {
			System.out.print(h+" ");
		}
		System.out.println();
		
	}
}
