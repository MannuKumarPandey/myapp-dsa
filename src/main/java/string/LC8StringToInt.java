package string;

public class LC8StringToInt {


    public static void main(String[] args) {
       // System.out.println(myAtoi("-042"));
        //System.out.println(myAtoi(" -042"));
      //  System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
    }

    public static int myAtoi(String s) {
        StringBuilder result = new StringBuilder();
        int flag = 1;
        for (char c : s.toCharArray()) {
            //check for leading space
            if (c == ' ' && result.length() == 0) {
                continue;
            }
            //check for - sign
            else if (c == '-' && result.length() == 0) {
                flag = -1;
            }
            //check for leading zeros
            else if (c == '0' && result.length() == 0) {
                continue;
            }

            else  if (Character.isDigit(c)) {
                result.append(c);
            }else{
                break;
            }

        }
        if(result.length() == 0){
            return 0;
        }
        int rr = Integer.parseInt(result.toString());
        if (flag == -1) {
            rr = -1 * rr;
        }
        return rr;
    }
}
