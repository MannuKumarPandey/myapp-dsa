package viveksingh;

public class ThisTest {

    //I am the already created object of the class where I am written,
    //But please do not use me in static method

    int x = 100;

    public static void main(String[] args) {
        new ThisTest().display();
    }


    public void display(){
        ThisTest t = new ThisTest();
        System.out.println(t.x);

        System.out.println(this.x);
    }
}
