package bitmanipulation;

public class ConvertNumberToOctaDecimal {

    public static void main(String[] args) {
        System.out.println(toOcta(5868));
        System.out.println(toOcta(78787878));
        System.out.println(toOcta(-1));

    }
    public static String toOcta(int num) {
        if (num == 0) {
            return "0";
        }
        char[] octaDecimalCharArray = new char[]{'0','1','2','3','4','5','6','7'};
        StringBuilder strBuilder = new StringBuilder();
        int count = 0;
        while (count < 12 && num != 0) {
            strBuilder.append(octaDecimalCharArray[num & 7]);  // yha 3 bit on ke liye 111 jiski value 7 hai se num ko and kiya to last 3 bit ki value mil gayi
            // uske bad us value se respective char value le liya, now num ko 11 times right shift kiya jisase fir dusri 3 bit ki value milgayi and so on.
            //StringBuilder me appending lasst me hoti hai so finally stringbuilder object to reverse kar denge.
            num = num >> 3;
            count++;
        }
        return strBuilder.reverse().toString();
    }
}
