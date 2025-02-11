package arrays;

import java.util.HashSet;

public class LC1805 {

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a1b01c001"));
    }

    public static int numDifferentIntegers(String word) {
        int result=0, i=0, n=word.length();
        HashSet<String> uniqueInteger = new HashSet<String>();

        while(i < n)
        {
            boolean flag=false;
            int start=i;

            while(i < n && Character.isDigit(word.charAt(i)))
            {
                i++;
                flag = true;
            }

            int end = i;
            String tempString = word.substring(start, end);

            if(flag)
            {
                StringBuilder s = new StringBuilder();
                int t=0;

                while(t < tempString.length() && tempString.charAt(t) == '0')
                {
                    t++;
                }

                while(t < tempString.length())
                {
                    s.append(tempString.charAt(t));
                    t++;
                }

                uniqueInteger.add(s.toString());
            }

            i++;
        }

        return uniqueInteger.size();
    }
}
