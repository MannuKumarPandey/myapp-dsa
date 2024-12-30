package MandeepDSA200HARD;

public class LC273IntegerToString {

    public static void main(String[] args) {
        System.out.println(numberToWords(1234567891)); // Example
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String[] belowTwenty = {
                "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String[] thousands = {"", "Thousand", "Million", "Billion"};

        StringBuilder result = new StringBuilder();

        int i = 0;

        //here we are calculating for the thousands
        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, helper(num % 1000, belowTwenty, tens) + thousands[i] + " ");
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private static String helper(int num, String[] belowTwenty, String[] tens) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return belowTwenty[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10, belowTwenty, tens);
        } else {
            return belowTwenty[num / 100] + " Hundred " + helper(num % 100, belowTwenty, tens);
        }
    }
}
