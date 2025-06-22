package DSA6;


//Array ---> int ---> 5 operations
public class Concept1 {

    public static void main(String[] args) {
        //operation 1: creation of Array of int in java
        int[] arr = new int[10];//1 way
        //size 10 : we have requested 10 memory for storage
        // naming of all 10 memories would start with 0
        //1st memory : 0
        //2nd memory : 1
        //3rd memory : 2


        //Operation 2: data insertion
        //it stores the data in index wise manner and index starts with 0
        /*arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        arr[7] = 8;
        arr[8] = 9;
        arr[9] = 10;*/

        for(int i=0; i<10; i++){
            arr[i]= i+1;
        }


        //Operation 3: Reading the data
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        for(int i=0; i<10; i++){
            System.out.println(arr[i]);
        }

        //Operation 4: updating the data
        //change the existing information
        //change the value of object 5(its name is 4) with 500
        arr[4] = 500;
        for(int i=0; i<10; i++){
            System.out.println(arr[i]);
        }


        //Operation 5: deletion
        //delete any index : eg: delete the index 5
        //direct index can not be deleted from created array
        //step 1: create new array of size 9
        int arr2[] = new int[9];
        //step 2: copy all the elements from previous array into new created array except index 5
        //index 0 se 4 tak ki data ko pahle rakh deta hu
        for(int i=0; i<5; i++){
            arr2[i] = arr[i];
        }
        //index 6 se 9 tak ki data ko arr2 me dal do
        for(int i= 6; i<10; i++){
            arr2[i-1]= arr[i];
        }

        /*for(int i=0; i<10; i++){
            if(i == 5){
                continue;
            }else if(i < 5){
                arr2[i] = arr[i];
            }else{
                arr2[i-1]= arr[i];
            }
        }*/


        for(int i=0; i<9; i++){
            System.out.println(arr2[i]);
        }
    }
}
