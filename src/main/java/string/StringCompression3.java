package string;

public class StringCompression3 {

    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcde"));
    }

    public static String compressedString(String word) {
        String result = "";
        int len = word.length();
        int i = 1;
        int freq = 1;
        while (i < len ) {
            while (i < len && freq <= 9) {
                if(freq == 9){
                    result = result + freq + word.charAt(i-1);
                    freq = 1;
                    i++;
                }
                else if (word.charAt(i-1) == word.charAt(i)) {
                    freq++;
                    i++;
                } else {
                    result = result + freq + word.charAt(i-1);
                    i++;
                    freq = 1;
                }
            }
        }
        result = result + freq + word.charAt(i-1);

        return result;
    }
}
