package timespacecomplexityanalysis;

import java.util.Arrays;

public class SpaceComplexityTest {

    //complexity of Additional space used to complete or perform the task is called the space complexity
    //we will execlude teh space of input
    //All the recursive activations records will be considered as extra spaces


    public static void main(String[] args) {
        int[] arrA = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        methodA(arrA);
        System.out.println(Arrays.toString(arrA));

        System.out.println("==================================================");
        int[] arrB = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        methodB(arrB);
        System.out.println(Arrays.toString(arrB));
    }

    //coder A : Time complexity: O(n), space complexity: O(1)
    //multiply all elements of arr by 2 and print the result
    public static void methodA(int[] arrA) {
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = arrA[i] * 2;
        }
    }

    //coder B Time complexity: O(2n) == O(n), space complexity: O(n)
    //multiply all elements of arr by 2 and print the result
    public static void methodB(int[] arrB) {
        int len = arrB.length;
        int[] result = new int[len];

        for (int i = 0; i < arrB.length; i++) {
            result[i] = arrB[i] * 2;
        }

        for (int i = 0; i < len; i++) {
            arrB[i] = result[i];
        }
    }

}
