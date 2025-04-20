package viveksingh;

public class CharacterOPerations {

    public static void main(String[] args) {

        //characters would be stored in their ASCII values internally
        System.out.println('a');//a-> ASCII value 97
        System.out.println((int)'a');//97
        System.out.println((int)'z');//122
        System.out.println((int)'A');//A-> 65
        System.out.println((int)'Z');//90

        System.out.println((char)90);

        for(int i=0; i<500; i++){
            System.out.println(i+" ---> "+(char)i);
        }

    }
}
