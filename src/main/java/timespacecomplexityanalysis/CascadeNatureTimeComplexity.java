package timespacecomplexityanalysis;

public class CascadeNatureTimeComplexity {


        //what is the time complexity of method1


// time complexity = 1+ n + n + n/10 + logn = 1+ 21n/10 + logn   ==== 1, n, logn
// O(n as the final complexity)



    public void method1(){

        int n = 100;  // 1 unit

        // O(n)
        for(int i = 1; i<= n; i++){
            System.out.println(i);
        }

        //O(n)
        for(int i = n; i >=1; i--){
            System.out.println(i);
        }

        //O(n/10)
        for(int i = 1; i<= n; i= i+10){
            System.out.println(i);
        }

        //o(logn)
        for(int i = 1; i<= n; i = i*2){
            System.out.println(i);
        }
    }
}
