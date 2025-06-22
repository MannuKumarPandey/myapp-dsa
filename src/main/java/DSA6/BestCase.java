package DSA6;

public class BestCase {

    public static void main(String[] args) {


        //Note: same code base will behave in different way with different input

        //Best case
        //time : 1 comparision
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int key = 1;//factor which is making this search operation best
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                System.out.println("Key found !");
                break;
            }
        }

        //Average Case: 4 comparsion
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        int key2 = 4;//factor which is making this search operation average
        for(int i=0; i<arr2.length; i++){
            if(arr2[i] == key2){
                System.out.println("Key found !");
                break;
            }
        }


        //worst case : +ve scenario
        //Time: 10 comparisions
        int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
        int key3 = 10;//factor which is making this search operation worst but result got found
        for(int i=0; i<arr3.length; i++){
            if(arr3[i] == key3){
                System.out.println("Key found !");
                break;
            }
        }

        //worst case : -ve scenario
        //Time: 10 comparisions
        int[] arr4 = {1,2,3,4,5,6,7,8,9,10};
        int key4 = 19;//factor which is making this search operation worst and result also did not get find
        for(int i=0; i<arr4.length; i++){
            if(arr4[i] == key4){
                System.out.println("Key found !");
                break;
            }
        }

    }


    //case prepare : arr and key jo best case bane
    public void search(int []arr, int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                System.out.println("Key found !");
                break;
            }
        }
    }
}
