package stack;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate( "(1+(4+5+2)-3)+(6+8)"));
    }


    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0;
        int sign = 1; //agar sign ki value 1` hai matlab positive hai agar -1 hai matlab -ve hai

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i); // har ek character ko pakadana hai 
            /* 1) characters ya to khali space hoga tab kuch bhi nahi karna hai
            2) Agar character koi digit hai to ye check karo ki kahi is ek digit ke sath koi auur value bhi to nahi added hai na
                    (means wo operand kahi ek se jyada digit ka to nahi hai na.)
            3) Agar '+' plus mila to us + character se pahle operand ki value ko us operand se pahle ki sign ke sath multiply
                    karke add kar dete hai. fir sign ko 1 kar dete hai jo ki age ke operands ke liye use hoga.
            4) Agar  '-' negative character mila to , us - character se pahle operand ki value ko us operand se pahle ki sign ke sath multiply
            karke result me add kar dete hai. fir sign ko -1 kar dete hai jo ki age ke operands ke liye use hoga.
            5) Agar '(' mila to us moment tabtak ki calculated result ko stack me rakh dete hai , aur sign value ko bhi rakh dete hai .
                    fir sign value ko +1 se start karte hai and result ko 0 se matlab ki ( ke bad ki result calculate karke fir us sign
                    se multiply karke result me multiply kar denge and so on.
            6) ye pura calculations left se right ki taraf jate wakt kiya ja rha hai. */

            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                result = result + (sign * operand);
                sign = 1;
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;

            } else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
