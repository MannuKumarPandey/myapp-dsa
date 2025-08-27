package arrays;

import java.util.HashMap;
import java.util.Map;

public class LC166FractionToRecurringDecimal {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4,333));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        //dono me se koi bhi number agar akela -ve hai to anss -ve ayega
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            ans.append("-");


        long num = (long) Math.abs((long) numerator);
        long den = (long) Math.abs((long) denominator);

        long quotient = num / den;
        long remainder = num % den;

        ans.append(String.valueOf(quotient));

        //agar first time me hi remainder ki value 0 ho gayi so return the ans
        ///means perfect division ho gaya hai
        if (remainder == 0)
            return ans.toString();
        ///agar nahi to ek decimal ke liye . add kijiye
        ans.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                //agar wo remainder already us map me hai tab uske position laye jab wo add ho rha tha tab
                //sb ki length kitani thi
                int pos = map.get(remainder);

                //fir usi position par ( add karene
                ans.insert(pos, "(");

                //and last me ) append karenge
                ans.append(")");
                return ans.toString();
            } else {
                //yhas map me ham us remainder ko rakh rahe hai jo digit jab ayi thi tab uske stringbuilder ke length kitane the
                map.put(remainder, ans.length());
                //fir remainder ko 10 se multiply kar rahe hai
                remainder *= 10;

                //wapis quotient and remainder prepare kar rahe hai
                quotient = remainder / den;
                remainder %= den;
                //us specific quotent ko and me add kar rahe hai
                ans.append(String.valueOf(quotient));
            }
        }

        return ans.toString();
    }
}