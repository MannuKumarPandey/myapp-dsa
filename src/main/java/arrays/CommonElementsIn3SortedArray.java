package arrays;

public class CommonElementsIn3SortedArray {

	public static void main(String[] args) {

		int a[] = new int[] {1,2,3,4,5,6,7,8,9};
		int b[] = new int[] {5,6,7,8,9,200,400};
		int c[] = new int[] {2,3,4,5,6,9};
		
		
		int i = 0, j = 0, k=0;
		int aLength = a.length, bLength = b.length, cLength = c.length;
		
		int res[] = new int[Math.max(cLength, Math.max(aLength, bLength))];
		int p = 0;
		while(i<= aLength-1 && j <= bLength-1 && k <= cLength-1) {
			if(a[i] == b[j] && a[i] == c[k] ) {
				res[p] = a[i];
				p++;
				i++; j++; k++;	
			}
			else if(a[i] < b[j] || a[i] < c[j]) {
				i++;
			}
			else if(b[j] < a[i] || b[j] < c[k]) {
				j++;
			}
			else if(c[k] < a[i] || c[k] < b[j]) {
				k++;
			}
		}
		
		for(int h: res) {
			System.out.print(h + " ");
		}
		System.out.println();
	}
}
