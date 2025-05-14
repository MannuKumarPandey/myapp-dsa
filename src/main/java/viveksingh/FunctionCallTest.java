package viveksingh;

public class FunctionCallTest {

    public static void main(String[] args) {
        Person p = createPerson();
        System.out.println(p.age);
        System.out.println(p.name);
    }


    public static Person createPerson(){
        Person pp = new Person(1,"MK");
        return pp;
    }

}
class Person{
    int age;
    String name;
    Person(int age, String name){
        this.age = age;
        this.name = name;
    }
}