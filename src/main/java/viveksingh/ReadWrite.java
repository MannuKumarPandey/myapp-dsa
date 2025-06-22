package viveksingh;

public @interface ReadWrite {
}



class A9{
    public void add(){
        System.out.println("1221212");
    }
}

class B9 extends A9{

    @Override
    public void add(){
        System.out.println("1221212");
    }



}
