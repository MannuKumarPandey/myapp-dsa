package string;

public class StringRotationUsingReverse {

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "bcdea";

        String s1 = "gcmbf";
        String goal1 = "fgcmb";

        for(int i=0; i<s.length(); i++){
           if(rightRotate(s, i).equals(goal) || leftRotate(s, i).equals(goal)){
               System.out.println(true);
               break;
           }
        }

        for(int i=0; i<s1.length(); i++){
            if(rightRotate(s1, i).equals(goal1) || leftRotate(s1, i).equals(goal)){
                System.out.println(true);
                break;
            }
        }
    }

    public static String leftRotate(String s, int k) {
        int strLen = s.length();
        s = reverseString(s, strLen-k, strLen-1);
        s = reverseString(s, 0, strLen - k - 1);
        s = reverseString(s, 0, strLen - 1);
        return s;
    }
    public static String rightRotate(String s, int k) {
        int strLen = s.length();
        s = reverseString(s, 0, k);
        s = reverseString(s, k+1, strLen - 1);
        s = reverseString(s, 0, strLen - 1);
        return s;
    }

    private static String reverseString(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        while (i <= j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        return sb.toString();
    }
}
