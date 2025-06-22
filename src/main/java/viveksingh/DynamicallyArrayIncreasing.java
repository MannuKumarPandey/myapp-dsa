package viveksingh;

import java.util.ArrayList;
import java.util.List;

public class DynamicallyArrayIncreasing {
    public static void main(String[] args) {

        List<Integer> al = new ArrayList<>();
        al.add(100);
        //jab ekbar array banane ke liye memory ki demand kar di gayi to
        //java me us memory ki size na to badayi ja sakati hai
        // na hi kam ki ja sakti hai
        //Static Array ka concept kahate hai
        ///jab ham static array banane jayenge tab  hame memory ki size mandatorly batana padega
        int[] arr = new int[10];
        arr[0]= 1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        arr[4]= 5; //50 % capacity fill ho gayi hai

        //1) ham ek naya array banate hai jisaki size pahle array se double hoti hai
        //2) Usake bad pahale array me se sari elements ko dusare naye array me copy kar di jati hai

        int [] arr2= new int[20];
        for(int i=0; i<arr.length;i++){
            arr2[i] = arr[i];
        }
    }
}
