package arrays;

public class FactorialOfALargeNumber {
	public static void main(String[] args) {
		int num = 10;
		
		int res[] = new int[500]; // creating result array of size 500
		res[0] = 1; //assigning first index as 1
		int res_size = 1; // now result size of array = 1
		
		 for (int x = 2; x <= num; x++) // Now 2 se lekar num tak ki multiplication ke liye loop chala
	            res_size = multiply(x, res, res_size); // har bar res_size wapis send karane ke liye 
		 // method se return mangawaya
		 // aur har ek element ko one by one pure array ke elements se muliply kiya
		 
		 
		 System.out.println("Factorial of given number is ");
	        for (int i = res_size - 1; i >= 0; i--)
	            System.out.print(res[i]);
	}
	static int multiply(int x, int res[], int res_size)
    {
        int carry = 0; // Initialize carry
 
        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry; 
            res[i] = prod % 10;
            // Store last digit of // Result ko left se bharate aa rahe hai qki multiply 
            // oposit se karna hota hai na isliye index 0 se
            // multiply karna assan hoga 
            // Jab result print karwana hoga to opposit se print karwane par 
            // original asnwer mil jayega
                                // 'prod' in res[]
            carry = prod / 10; // Put rest in carry
        }
 
        // Put carry in res and increase result size
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }
}
