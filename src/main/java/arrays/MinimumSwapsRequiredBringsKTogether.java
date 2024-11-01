package arrays;

public class MinimumSwapsRequiredBringsKTogether {

	public static void main(String[] args) {
		/*
		 * Given array me se kitane swap karne padenge minimum so that all the elements
		 * <= given k eksath aa jaye.
		 */
		
		int array[] = new int[] {1,2,5,3,7};
		int k = 3;
		int n = array.length;
		
		int good = 0;// wese elements jo k se ya to chhote hai ya barabar hai
		int bad = 0; // wese element jo k se bade hai
		
		//counting good values in whole array
		for(int i =0; i< n; i++) {
			if(array[i] <= k)
				good++;
		}
		// to above work se good = 3 ayega matlab 3 windows size agar pakada jaye to 
		// ham track kar sakte hai
		
		//counting bad values in the current window: current window matlab 0 to good-1
		for(int i=0; i<good; i++) {
			if(array[i] > k ) {
				bad++; // bad value corrent window me aya 1
			}
		}
		
		int i =0;
		int j= good;
		int ans = bad;
		
		while(j<n) {
			// if the start of window was the bad value reduce bad count by 1
			if(array[i] > k) { // windows badhate chalo if 0th wala index ka value k se bada tha to ek ghata do 
				//qki ab window shift ho jayegi aage
				bad --;
			}
			// if the end of window is the bad value increase bad count by 1
			// Agar ane wala element k se bada hai to windows me bad elements ki number badhao
			if(array[j] > k) {
				bad ++;
			}
			
			ans = Math.min(ans, bad); // here count the minimum bad elements 
			i++;
			j++;
		}
		System.out.println(ans);
	}

}
