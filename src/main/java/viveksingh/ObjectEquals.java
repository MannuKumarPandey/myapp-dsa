package viveksingh;

class Person1 {
    String name;
    Person1(String name) {
        this.name = name;
    }
}
public class ObjectEquals {
    public static void main(String[] args) {
        Person1 p1 = new Person1("John");
        Person1 p2 = new Person1("John");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        System.out.println(p1.name.equals(p2.name));

    }
}

