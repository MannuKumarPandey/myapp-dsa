package viveksingh;

public class LinearSearch {


    public static boolean linearSearch(int arr[], int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{20,50,90,110,550,990,1100}, 550));
    }
}
//Time complexity: O(n)---> Linear function
//if array has n number of elements then we must have to traverse all the n elements.
//Binary search -> O(log n) which is lesser than O(n) -> but here Given array must be in sorted manner.