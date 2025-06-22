package MandeepDSA200HARD;

public class Test1 {
    Test1 t = new Test1();

    Test1() {
        throw new ArithmeticException();
    }

    public static void main(String[] args) {
        try {
            Test1 t2 = new Test1();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ABC");
        }
    }
}
