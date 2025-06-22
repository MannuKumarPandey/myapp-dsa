package viveksingh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class CompileTimeExceptionHandle {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(Arrays.toString(args));


        System.out.println(100 / 0);//Run time exception

        try {
            FileReader fr = new FileReader("");
        } catch (FileNotFoundException a) {
            throw new ArithmeticException();
        }


        // FileReader fr = new FileReader("a://asap.txt");//compile time exception
        //1) ya to to usko try catch me dalo

        //2) nahi to usko method signature me jakar throws se declare karo
    }

    public static void fileWrite(){

    }
}
