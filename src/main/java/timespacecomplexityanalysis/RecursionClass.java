package timespacecomplexityanalysis;

public class RecursionClass {

    public static void main(String[] args) {
        method1(100); // n= 100
        method2(100);
    }


    //Time complexity : O(n)
    //space complexity: O(n) because we will be assigned n memory segment of stack to complete the methods tasks
    public static void method1(int n) {
        //base case
        if (n < 1) {
            return;
        }
        System.out.println(n);
        method1(n - 1);
    }


    //Time complexity : O(log^2n) where base is 2
    //space complexity: O(log n)
    public static void method2(int n) {

        //base case
        if (n < 1) {
            return;
        }

        System.out.println(n);
        for(int i = 1; i<= n; i++){
            System.out.println(i);
        }

        method2(n /2);
    }

}
