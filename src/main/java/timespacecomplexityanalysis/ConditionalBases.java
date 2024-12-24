package timespacecomplexityanalysis;

public class ConditionalBases {


    public static void method1(int n) {

        if (n % 2 == 0) { //O(n)
            for (int i = 1; i <= n; i++) {
                System.out.println(i);
            }
        } else { //O(logn)
            for (int i = 1; i <= n; i = i * 2) {
                System.out.println(i);
            }
        }
    }

    // final time complexity : either O(n)  or O(logn)
    // in this case we will return the worst case time complexity : bigger function
}
