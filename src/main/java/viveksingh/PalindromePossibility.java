package viveksingh;

public class PalindromePossibility {
    public static void main(String[] args) {
        int arr[] = {2,1,3,1,2};


        //pahli condition without any rotation is the original array palindrome or not?
        for(int i = 0; i<arr.length;i++){

        }
    }


    public static boolean palindromeChecker(int []arr){
        for(int i=0; i<arr.length/2; i++){
            if(arr[i] != arr[arr.length-i-1]){
                return false;
            }
        }
        return true;
    }


    public static void rotate(){

    }

    public static void reverse(){

    }


}
