package recursion;

public class RecursionPalindrome {

    public static void main(String[] args) {
        int num=121;
        int orgNum=num;
        int r=0, store=0;
        store=palindrome(num, r, store);
        if(orgNum==store){
            System.out.println("palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }
    static  int palindrome(int num, int r, int store){
        if(num==0){
            return store;
        }
        r=num%10;
        store=(store*10)+r;
        num=num/10;
        int pp = palindrome(num, r, store);
        return pp;
    }

}