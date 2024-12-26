package timespacecomplexityanalysis;

public class NestedLoops {

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {

        int n = 100;  // 1 unit

        //overall time complexity: O(n^2) ---> quadratic function
        //outer loop 100 times
        for (int i = 1; i <= n; i++) {
            // inner loop will run 100 time
            for (int j = 1; j <= n; j++) {
                System.out.println(i + " " + j);
            }
        }


        //overall time complexity: O(n * logn)
        for (int i = 1; i <= n; i++) {  //n
            for (int j = 1; j <= n; j = j * 2) { //log n
                System.out.println(i + " " + j);
            }
        }


        //overall time complexity: O(n * logn)
        for (int j = 1; j <= n; j = j * 2) { //log n
            for (int i = 1; i <= n; i++) {   // n
                System.out.println(i + " " + j);
            }
        }


        //overall time complexity: O(n^3) ---> cubic
        for (int i = 1; i <= n; i++) { // n
            for (int j = 1; j <= n; j++) { //n
                for (int p = 1; p <= n; p++) { //n
                    System.out.println(i + " " + j);
                }
            }
        }


        //overall time complexity: O(n^2 * logn)
        for (int i = 1; i <= n; i++) { // n
            for (int j = 1; j <= n; j= j*2) { //logn
                for (int p = 1; p <= n; p++) { //n
                    System.out.println(i + " " + j);
                }
            }
        }

    }
}
