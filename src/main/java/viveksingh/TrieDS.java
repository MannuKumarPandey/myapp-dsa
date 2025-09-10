package viveksingh;

public class TrieDS {

    //Har ek characetr ka ek ASCII value hota hai
    public static void main(String[] args) {
        System.out.println('a');
        System.out.println((int)'a');//97 is the ASCII value of a
        System.out.println((int)'z');//122 is the ASCII value of a

        System.out.println((int)'A');//65 is the ASCII value of a
        System.out.println((int)'Z');//90 is the ASCII value of a

        System.out.println((char)(97+'a'));//ASCII value
        System.out.println("===================");
        System.out.println((int)'a'-(int)'a');//char input is getting converted into its ASCII value
        System.out.println((int)'a'-(int)'a');//char input is getting converted into its ASCII value

        System.out.println('a'+" "+ 7);


        System.out.println("==================================");
        String s1 = "vivek";
        String s2 = "vivek";

        if(s1.length() != s2.length()){//O(length of s1 + length of s2)
            System.out.println("Strings are not matching.");
        }else{
            int i=0;
            int j=0;
            while(i < s1.length()){
                if(s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else{
                    System.out.println("Strings are not matching.");
                }
            }
            System.out.println(i == s1.length()? "String is matching": "false");
        }


        System.out.println(s1.equals(s2));//O(length of s1/s2)
    }
}
