package arrays;

public class ReverseAnArray {
	public static void main(String[] args) {
		int x[] = new int[] {1,2,3,4,5,6,7,8,9,10};
		int y[] = new int[x.length]; // here we are using extra space in this : we should use two pointers approach
		///which will do the same in O(n)
		int p = 0;
		for(int i= x.length-1; i>=0; i--) {
			y[p] = x[i];
			p++;
		}
		for(int g: y) {
			System.out.print(g+ " ");
		}
		System.out.println();
	}
}
