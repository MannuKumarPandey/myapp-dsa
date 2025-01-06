package recursion;

public class StackOverflowNature {

    public static void main(String[] args) {
        test(15000);
    }

    public static void test(int n){
        String s1 ="123";
        String s10 ="123";
        String s11 ="123";
        String s100 ="123";
        String s111 ="123";
        String s1000 ="123";
        String s11110 ="123";
        String s145 ="123";
        String s1475 ="123";
        String s1455 ="123";
        String s1032 ="123";
        String s187 ="123";
        String s198 ="123";
        String s166 ="123";
        String s199 ="123";
        String s188 ="123";
        String s1002 ="123";
        String s19898 ="123";
        String s1458 ="123";
        String s1457878 ="123";




        if(n == 0){
            return;
        }
        System.out.println(n);
        test(n-1);
    }
}
