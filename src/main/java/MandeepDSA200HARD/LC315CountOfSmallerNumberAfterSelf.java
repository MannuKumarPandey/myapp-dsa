package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC315CountOfSmallerNumberAfterSelf {

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}).toString());
    }


    public static List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<Integer>();


        ArrayList<Integer> inputArrayList = new ArrayList<Integer>();
        for (int num : nums) inputArrayList.add(num);
        Collections.sort(inputArrayList);//[1 2 5 6]


        for (int i = 0; i < len; i++) {
            int index = binarySearch(inputArrayList, nums[i]);
            result.add(index);
            inputArrayList.remove(index);
        }

        return result;
    }

    public static int binarySearch(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            int val = arr.get(mid);
            if (val < target) start = mid + 1;
            else end = mid - 1;
        }
        if (arr.get(start) == target) return start;
        return mid;
    }
}
