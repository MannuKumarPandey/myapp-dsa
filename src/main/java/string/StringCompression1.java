package string;

public class StringCompression1 {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }
    public static int compress(char[] chars) {

        String result = "";
        int len = chars.length;
        int i = 1;
        int freq = 1;

        while (i < len ) {
            if (chars[i-1] == chars[i]) {
                freq++;
                i++;
            } else {
             if(freq > 1)   result = result +chars[i-1]+ freq;
                i++;
                freq = 1;
            }
        }
        if(freq > 1) result = result +chars[i-1]+ freq;
        if(result.length() > chars.length){
            char[] arr = new char[result.length()];
        }

       for(int j=0; j< result.length(); j++){
           chars[j] = result.charAt(j);
       }
        return result.length();
    }
}
