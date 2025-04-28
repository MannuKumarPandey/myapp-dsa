package viveksingh;

public class DuplicatesfromArray {


    public static void main(String[] args) {
        int arr[] = {1,2,3,2,3,3,4,4,5,5,0,0,5,6,7,8,9,12,12,12};// o/p: 2,3
        int len = arr.length;

        int max = Integer.MIN_VALUE;
        for(int a: arr){
            max = Math.max(max,a);
        }

        int freq[] = new int[max+1];
        for(int a: arr){
            freq[a]++;
        }

        for(int i=0; i<max+1;i++){
            if(freq[i] > 1){
                System.out.println(i);
            }
        }

    }
}
