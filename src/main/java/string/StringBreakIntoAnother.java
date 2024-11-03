package string;

import java.util.Arrays;

public class StringBreakIntoAnother {
    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc", "xya"));
    }

    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean flag = true;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < arr2[i]) {
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }
        flag = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
