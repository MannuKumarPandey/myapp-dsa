package timespacecomplexityanalysis;

public class StackOverFlowCase {
    public static void main(String[] args) {
        method1(100); // n= 100
    }


    //Time complexity : O(infinite)
    //space complexity: O(infinite) stack over flow
    public static void method1(int n) {
        //base case
        /*if (n < 1) {
            return;
        }*/
        System.out.println(n);
        method1(n - 1);
    }

}
