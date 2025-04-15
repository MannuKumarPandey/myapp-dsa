package viveksingh;

public class ThreadTest2 {

    public static void main(String[] args) {
        Test5 t = new Test5();
        Thread t5 = new Thread(t);
        t5.start();
    }
}
class Test5 implements  Runnable{

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("Testings !");
        }
    }
}