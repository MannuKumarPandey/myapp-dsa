package bitmanipulation;

public class ConvertNumberToHexadecimal {

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));

    }
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] hex = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder strBuilder = new StringBuilder();
        int count = 0;
        while (count < 8 && num != 0) {
            strBuilder.append(hex[num & 15]);  // yha 4 bit on ke liye 1111 jiski value 15 hai se num ko add kiya to last 4 bit ki value mil gayi
            // uske bad us value se respective char value le liya, now num ko 4 times right shift kiya jisase fir dusri 4 bit ki value milgayi and so on.
            //StringBuilder me appending lasst me hoti hai so finally stringbuilder object to reverse kar denge.
            num = num >> 4;
            count++;
        }
        return strBuilder.reverse().toString();
    }
}
