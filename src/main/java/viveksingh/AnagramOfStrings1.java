import java.util.Arrays;

public class AnagramOfStrings1 {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "deabcf";

        int[] freqArray1 = new int[26];
        for(int i=0; i<s1.length(); i++){
            int index = s1.charAt(i)-'a';//char1-char2   ===> ASCII value of char1 - ASCII value of char2
            freqArray1[index]++;
        }

        int[] freqArray2 = new int[26];
        for(int i=0; i<s2.length(); i++){
            int index = s2.charAt(i)-'a';//char1-char2   ===> ASCII value of char1 - ASCII value of char2
            freqArray2[index]++;
        }

      /*  for(int i=0; i<26; i++){
            if(freqArray1[i] != freqArray2[i]){
                System.out.println("String are not anagram to each other");
                break;
            }
        }
        System.out.println("String are anagram to each other");*/

        if(Arrays.equals(freqArray1,freqArray2)){
            System.out.println("Both strings are anagram to each other.");
        }else{
            System.out.println("Both strings are not anagram to each other.");
        }


    }
}
