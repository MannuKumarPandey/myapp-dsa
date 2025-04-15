package viveksingh;

public class SuperTest {
}


class A {
    A(){

    }
    int x = 100;
}

//super : mai jis class me likha ja rha hu uske parent class ka bana bnaya object hu
//but mujeh kisi bhi static method ke under use mat karna


class B extends A{
    public void display(){
        A a = new A();
        System.out.println(a.x);

        System.out.println(super.x);
    }
   /* public static  void add(){
        System.out.println(super.x);
    }*/
}