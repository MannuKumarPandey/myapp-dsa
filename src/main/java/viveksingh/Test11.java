package viveksingh;

public class Test11 {

    public static void main(String[] args) {
        System.out.println(5&9);
        System.out.println(5|9);
        System.out.println(5^9);


        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(7));

        /*int a = 3;
        int c = -7;
        int d = -546456456465465;
        int b = 4545646554546;*/

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);



        int g = 100;//primitive data types storage
        System.out.println(g);
        Integer obj  =Integer.valueOf(g);//wrapper object storage
        System.out.println(obj);


    }
}
