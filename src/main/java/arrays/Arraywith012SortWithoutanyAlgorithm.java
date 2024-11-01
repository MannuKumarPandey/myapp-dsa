package arrays;

public class Arraywith012SortWithoutanyAlgorithm {
	public static void main(String[] args) {

		/*
		 * 3 pointers ka use kar sakte hai , low, mid and high agar array[mid] == 0 then
		 * swap array[low] and array[mid] and increase low and mid agar array[mid] == 1
		 * then just increase mid agar array[mid] == 2 then swap with high and decrease
		 * high pointer
		 * 
		 * Repeat above step until mid <= high
		 */
		
		int array[] = new int[]{0,2,1,0,2,1,0,1,0,2,0};
		int low = 0, mid= 0;
		int high = array.length-1;
		while(mid<=high) {
			if(array[mid]==0) {
				int temp = array[low];
				array[low] = array[mid];
				array[mid]= temp;
				low++;
				mid++;
				
				//swap with low and increase low and high both the pointers
			}
			else if(array[mid] == 1) {
				//increase the mid pointer 
				mid++;
			}
			else if(array[mid] == 2) {
				// swap mid value with high pointer and decrease high 
				int temp = array[mid];
				array[mid] = array[high];
				array[high] = temp;
				high--;
			}
		}
		for(int g: array) {
			System.out.print(g);
		}
		System.out.println();
	}
}
