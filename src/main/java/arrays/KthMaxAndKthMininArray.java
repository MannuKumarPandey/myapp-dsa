package arrays;

import java.util.Arrays;

public class KthMaxAndKthMininArray {
	public static void main(String[] args) {
		int array[] = new int [] {2,5,3,4,7,6,18,90,24,37};
		int k = 3;
		// find the 3rd min and max
		// if I do in sorting way then atleast nlogn is required 
		Arrays.sort(array);
		System.out.println("Kth max::::" + array[array.length-k]);
		System.out.println("kth min element is ::::" + array[k-1]);
	}
}
