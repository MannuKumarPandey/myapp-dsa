package viveksingh;

public class NegationOfANumber {

    public static void main(String[] args) {
        int n = 5;
        //ones complement
        n = ~n;

        //2s complement
        n = n+1;

        System.out.println(n);
    }
}
