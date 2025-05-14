package viveksingh;

public class Print1toNUsingRecursion {

    public static void main(String[] args) {
        print(1,100);
    }



    public static void print(int cur , int n){
        //base case--> base condition
        if(cur > n){
            return;
        }

        //accesing the data -> operations on data
        System.out.println(cur);

        //recursive calls with modified parameters
        print(cur+1 , n);
    }
}
