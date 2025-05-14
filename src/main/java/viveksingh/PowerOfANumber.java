package viveksingh;

public class PowerOfANumber {
    public static void main(String[] args) {
        int a = 2;
        int b= 3;
        // a^b = a * a*a*a* ----b time *a
        //2^3 = 2*2*2

        int result = 1;
        for(int i=0;i<b;i++){
            result= result*a;
        }

        System.out.println(result);

    }
}
