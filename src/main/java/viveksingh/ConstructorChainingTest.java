package viveksingh;

public class ConstructorChainingTest {

    //yha ham jab child class ke costructor ko call kar rahe hai tab wo apane construcctor
    //ke under se parent class ke constructor ko call kar rha hai aur wo
    //cunstomized call kar sakta hai is constructors calls ke chain ko constructor chaining kahte hai


    public static void main(String[] args) {
        Q q = new Q();
    }
}


class P{
    int a = 100;
    int b = 200;
    P(){
        System.out.println("0 parameterized constructor");
    }
    P(int a ){
        System.out.println("i parameterized constructor having int" + a);
    }

    P(char d){

    }

    P(int a, char b){

    }


}




class Q extends P{
    Q(){
        super(1000);
    }

    int x = 300;
    int y = 400;

}