package MandeepDSA200HARD;

public class Test2 {
    Test2(){
        System.out.println("I am from constructor !");
    }
    static {
        System.out.println("I am from static block !");
    }
    {
        System.out.println("I am from normal block !");
    }

    public static void main(String[] args) {
        System.out.println("main method line 1");
        new Test2();
        System.out.println("main method line 2");
    }
}
