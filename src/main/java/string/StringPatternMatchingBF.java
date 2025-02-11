package string;

public class StringPatternMatchingBF {

    public static void main(String[] args) {
        String s1 = "Hello World"; //n
        int len1 = s1.length();
        String pattern ="World";//m
        int lenP = pattern.length();
        int i =0;
        int j=0;
        while(i<len1){
            while(i<len1 && j <lenP && s1.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == lenP){
                System.out.println(i-lenP);
            }
            else{
                j = 0;
                i++;
            }
        }
    }
}
