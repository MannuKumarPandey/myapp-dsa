package bitmanipulation;

public class NumberToHexadecimal {

    public static void main(String[] args) {
        System.out.println(new NumberToHexadecimal().toHex(26));
    }

    public static String getChar(int num) {
        String temp = "";
        switch (num) {
            case 10:
                temp = "a";
                break;
            case 11:
                temp = "b";
                break;
            case 12:
                temp = "c";
                break;
            case 13:
                temp = "d";
                break;
            case 14:
                temp = "e";
                break;
            case 15:
                temp = "f";
                break;
        }
        return temp;
    }

    public String toHex(int num) {

        if (num == -1) {
            return "ffffffff";
        }

        String res = "";

        while (num > 16) {
            res = res + num / 16;
            num = num % 16;
        }
        res = res + getChar(num);
        return res;
    }
}
