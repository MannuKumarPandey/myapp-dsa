package viveksingh;

public class LogicalAndOrNotTest {

    public static void main(String[] args) {
        //case 1 : Logical AND
        int a = 12;//1100
        int b = 11;//1011
        //===================
        //And will be 1000-> 8
        System.out.println(a & b);


        //case 1 : Logical OR
        int c = 12;//1100
        int d = 11;//1011
        //===================
        //OR will be 1111-> 15
        System.out.println(a | b);


        int e = 10;
        //10 = 1010
        //not of 10 = 0101 = 5
       // System.out.println(!e);
    }
}
