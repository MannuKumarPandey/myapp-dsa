package math;

import java.util.ArrayList;

public class AllthefactorsOfANumber {

    public static void main(String[] args) {

        int n = 100;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    list.add(i);
                } else {
                    int d = n / i;
                    list.add(i);
                    list.add(d);
                }
            }
        }

        System.out.println(list.toString());

    }

}

