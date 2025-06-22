package MandeepDSA200HARD;

public class Test11 {



    public static void main(String[] args) {
        try{
            System.out.println("abc");
           // System.exit(1);

            System.gc();

        }catch (ArithmeticException e){
           // throw NullPointerException();
            System.out.println("def");
        }catch(NullPointerException e1){

        }
        finally {
            System.out.println("ghi");
        }


    }
}
