import java.util.Arrays;

public class Anagram2 {

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "deabcf";

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);//Ascending order
        Arrays.sort(arr2);

        if(Arrays.equals(arr1,arr2)){
            System.out.println("Both strings are anagram to each other.");
        }else{
            System.out.println("Both strings are not anagram to each other.");
        }

    }
}
