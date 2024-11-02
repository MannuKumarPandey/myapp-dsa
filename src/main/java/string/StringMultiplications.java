package string;

public class StringMultiplications {

	public static void main(String[] args) {

		
		String s1 = "1265446545";
		String s2 = "1289789779";
		
		int length1= s1.length();
		int length2 = s2.length();
		
		int[] res = new int[length1+length2];
		
		int i = length2 - 1;
		
		int pf = 0; //power factor hasil
		
		while(i>=0) {
			int ival = s2.charAt(i) - '0'; // zero ASCII values ke liye ghatana pad rha hhai
			i--;
			int j = length1 - 1;
			int k = res.length - 1 - pf;
			int carry = 0;
			
			while(j >= 0 ||  carry != 0) {
				int jval = j >= 0 ? s1.charAt(j) - '0' : 0;
				j--;
				int prod = ival * jval + carry + res[k]; 
				res[k] = prod % 10;
				carry = prod / 10;
				k--;
			}
			pf++;
		}
		
		for(int h : res) {
			System.out.print(h);
		}
		System.out.println();
	}
}
