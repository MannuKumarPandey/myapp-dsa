package arrays;

public class UnionAndIntersectionOfTwoSortedArray {
	public static void main(String[] args) {
		intersectionOfTwoSotedArrays();
		unionOfTwoSotedArrays();
	}

	public static void unionOfTwoSotedArrays() {
		int a[] = new int[] { 1, 4, 7, 9, 11, 16, 19, 100 };
		int b[] = new int[] { 2, 6, 9, 35, 40, 199 };

		int unionArray[] = new int[a.length +b.length];
		int i = 0;
		int j = 0;
		int p = 0;

		while (i <= a.length - 1 && j <= b.length - 1) {
			if (a[i] < b[j]) {
				unionArray[p++]= a[i];
				i++;
			}else if (a[i] > b[j]) {
				unionArray[p++]= b[j];
				j++;
			}else {
				unionArray[p++] = a[i];
				i++;
				j++;
				
			}
		}
		// Add the last elements which are remaining from any of the arrays 
		  while (i < a.length) {
	            unionArray[p++] =a[i++];
		  }
	        while (j < b.length){
	            unionArray[p++] =b[j++];
		  }
		for (int f : unionArray) {
			System.out.print(f + " ");
		}
		System.out.println();

	}
	
	public static void intersectionOfTwoSotedArrays() {
		int a[] = new int[] { 1, 4, 7, 9, 11, 16, 19, 100 };
		int b[] = new int[] { 2, 6, 9, 35, 40, 199 };

		int interSectionArray[] = new int[Math.max(a.length, b.length)];
		int i = 0;
		int j = 0;
		int p = 0;

		while (i <= a.length - 1 && j <= b.length - 1) {
			if (a[i] > b[j]) {
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				interSectionArray[p] = a[i];
				i++;
				j++;
				p++;
			}
		}
		for (int f : interSectionArray) {
			System.out.print(f + " ");
		}
		System.out.println();

	}
}
