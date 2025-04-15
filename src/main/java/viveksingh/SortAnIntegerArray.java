package viveksingh;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortAnIntegerArray {

    public static void main(String[] args) {
        int arr[] = {1,2,1,0,1,2,0,1,2};//Gurantee 0,1,2


        int zeroc = 0;
        int onec = 0;
        int twoc = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                zeroc++;
            }else if(arr[i] == 1){
                onec++;
            }else{
                twoc++;
            }
        }


        Arrays.sort(arr);//nlogn
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
