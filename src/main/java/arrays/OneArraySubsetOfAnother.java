package arrays;

import java.util.HashSet;

public class OneArraySubsetOfAnother {
	public static void main(String[] args) {
		
		// second array ke sare elemenst first array me hai ki nahi 
		// kisi bhi order me ho usase matlab nahi hai
		int array1[] = new int[] {1,2,3,4,5,6,7,8,89,100};
		int array2[] = new int [] {3,4,56,7,8};
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		for(int g: array1) {
			if(!hs1.contains(g)) {
				hs1.add(g);
			}
		}
		
		for(int h: array2) {
			if(!hs1.contains(h)) {
				System.out.println(false);
				return;
			}
		}
	}
}
