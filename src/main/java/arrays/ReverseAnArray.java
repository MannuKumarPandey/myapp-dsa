package arrays;

public class ReverseAnArray {
	public static void main(String[] args) {
		int x[] = new int[] {1,2,3,4,5,6,7,8,9,10};
		int y[] = new int[x.length];
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
