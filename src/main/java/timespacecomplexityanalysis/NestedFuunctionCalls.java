package timespacecomplexityanalysis;

public class NestedFuunctionCalls {


    public static void main(String[] args) {
        method1(100);
    }

    public static void method1(int n){
        for(int i = 1; i<n; i++){ //O(n)
            for(int j = 1; j<= n; j= j*2){ //O(log n)
                method2(n/2); // resultant time complexity of method2 * O(n) * O(logn)
            }
        }
    }

    public static void method2(int n){

        if(n <= 0 ){
            return;
        }

        for(int i = n; i >= 1; i = i-50){ //n/50 * log(n)
            System.out.println(i);
            method2(n/2);
        }


    }
}
