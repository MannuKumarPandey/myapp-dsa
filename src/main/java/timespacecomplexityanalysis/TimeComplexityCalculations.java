package timespacecomplexityanalysis;

public class TimeComplexityCalculations {
    public static void main(String[] args) {

        //O(Big O)  ---> uppper bound(worst case)
        //theta---------> lower bound(best case)
        //Omega---->     average case


        // O(1) constantfunction   < O(logn)   <  O(n) linear   < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!)


        // 1) input length (n) = 1000
        //2) how many times loop(code base) is running

        int n = 1000;

        //O(n) = linear nature
        for(int i = 1; i<= n ; i++){
            System.out.println(i);
        }


        //O(n) = linear nature
        int i = 1;
        while( i<= n ){
            System.out.println(i);
            i++;
        }


        //O(n) = linear nature
        int j = 1;
        do{
            System.out.println(j);
            j++;
        }while( j<= n );


        /*when the increasing/decreasing factor is getting multiply by some constant
        it reaches raplidly in multiplication of that factor to n
        its time complexity will become O(log n ) where base is that constant*/
        //O(log n)
        for(int p = 1; p<= n; p= p*2){
            System.out.println(p);
        }


        //O(log n)
        for(int p = n; p >= 1 ; p= p/2){
            System.out.println(p);
        }

    }
}
