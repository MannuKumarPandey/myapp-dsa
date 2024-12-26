package string;

class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("1230", "456000000000000000000000000001"));
    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || (num2.equals("0"))) return "0";

        int[] resultantArray = new int[num1.length() + num2.length()];

        int resultantArrayPointer = resultantArray.length - 1, carry = 0, j = num1.length();

        for (int i = num2.length() - 1; i >= 0; i--) {

            int hasillenewala = resultantArrayPointer;
            carry = 0;
            j = num1.length() - 1;

            while (j >= 0) {
                // char to int converstion num1.charAt(j) - '0'
                int actualMultip = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                actualMultip += carry;
                carry = (actualMultip + resultantArray[resultantArrayPointer]) / 10;
                resultantArray[resultantArrayPointer] = (resultantArray[resultantArrayPointer] + actualMultip) % 10;
                j--;
                resultantArrayPointer--;
            }

            if (carry > 0) {
                resultantArray[resultantArrayPointer--] = carry;
            }
            resultantArrayPointer = hasillenewala - 1;
        }

        StringBuilder s = new StringBuilder();
        boolean is = false;
        for (int i = 0; i < resultantArray.length; i++) {
            if (resultantArray[i] > 0) {
                is = true;
            }
            if (is) {
                s.append(resultantArray[i]);
            }
        }
        return s.toString();
    }
}

