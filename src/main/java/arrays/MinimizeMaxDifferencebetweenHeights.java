package arrays;

import java.util.Arrays;

public class MinimizeMaxDifferencebetweenHeights {
	
	/*
	 * Hame kuch towers ki heights di gayi hai aur ek value k = something , jis k ko
	 * har tower ke heights me ya to jod sakte hai ya fir ghata sakte hai but wo
	 * addition ya subtraction sirf ekbar hi kar sakte hai, ab is operation ko is
	 * tarah karna hai ki max difference between heights ko jitna kam se kam ho sake
	 * karna hai.
	 * Ye optional hai ki ham us k value ko jode ya nahi jode, agar max difference pahle hi kafi chhota aa
	 * raha hai to jodane ya ghatane ki koi jarurat nahi hai.
	 * 
	 * Approach: pahle sare heights ko sort kar lete hai fir first index me jokar
	 * and last index wale me se ghata kar difference dekhte hai agar wo minimum
	 * aata hai to wahi answer hoga.
	 */
	
	public static void main(String[] args) {
		int array[] = new int[] {1, 5, 15, 10};
		int n = array.length;
		int k = 3;
		Arrays.sort(array); //[1,5,10,15]
		// Maximum possible height difference
        int ans = array[n - 1] - array[0];
		int tempMin = array[0];
		int tempMax = array[n-1];
		for(int i= 1; i<=array.length-1; i++) {
			
			if(array[i]-k < 0)
				continue;
			
			// Minimum element when we add k to whole array
            tempMin = Math.min(array[0] + k, array[i] - k);
         // Maximum element when we subtract k from whole
            // array
            tempMax = Math.max(array[i - 1] + k, array[n - 1] - k);
			ans = Math.min(ans, tempMax - tempMin);
		}
		System.out.println(ans);
	}
}
