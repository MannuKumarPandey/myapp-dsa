package viveksingh;

public class NumberFindFromString {


    public static void main(String[] args) {
        String s = "12345+";
        String result = "";
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                result = result+String.valueOf(c);
            }
        }
        System.out.println(result);
        int num = Integer.parseInt(result);
        System.out.println(num);
    }
}
