package arrays;

import java.util.Arrays;

public class ChocolateDistribution {

	public static void main(String[] args) {
		/*
		 * problem is we have an array of integers jo ki number of chocolates in packets
		 * denote kar rha hai task is ki hame m number of given student diye gaye hai
		 * and hame sare students ko ek ek packet chocolate dena hai but condition ye
		 * hai ki chockolate ke packet ke bich ki differences minimum ho
		 */

		/*
		 * Approach is : ki sabse pahle array ko sort kar lete hai and usake bad m
		 * length ke sub array me se first and last index ke bich ka diference le lete
		 * hai jo minum hoga wahi answer hoga.
		 */
		int array[] = new int[] { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };
		int m = 7;
		Arrays.sort(array);// [2,3,4,7,9,12,56]

		int minDifference = Integer.MAX_VALUE;

		for (int i = 0; i + m - 1 < array.length; i++) {
			int first = i;
			int last = i + m - 1;
			if (array[last] - array[first] < minDifference) {
				minDifference = array[last] - array[first];
			}
		}
		System.out.println(minDifference);
	}
}
