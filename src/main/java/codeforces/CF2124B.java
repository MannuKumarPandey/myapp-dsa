package codeforces;

import java.util.Scanner;

public class CF2124B {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ttc = scan.nextInt();

        for (int i = 0; i < ttc; i++) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }

            int min[] = new int[n];
            min[0] = arr[0];
            int result = arr[0];
            for (int k = 1; k < n; k++) {
                min[k] = Math.min(min[k - 1], arr[k]);
                result = result + min[k];
            }
            System.out.println(result);

        }
    }

}