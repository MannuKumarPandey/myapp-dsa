package viveksingh;

public class Plaindromeofanumber {

    public static void main(String[] args) {
        int a= 343;
        String s = String.valueOf(a);
        StringBuilder sb = new StringBuilder(s);
        if(sb.reverse().toString().equals(s)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not a palinrome");
        }
    }
}
