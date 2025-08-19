package string;

import java.util.Arrays;
import java.util.Comparator;

public class SortWordsWithLengthManner {

    public static void main(String[] args) {
        String input = "Leetcode is cool";

        String[] arr = input.split(" ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(arr));
    }
}
