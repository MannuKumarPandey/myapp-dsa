package viveksingh;

import java.util.ArrayList;

public class SlidingWindowFixedSize {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 6, 7, 8, 9, 10};
        int windowSize = 3;
        int len = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        //outer loop: left index fix
        for (int i = 0; i < len - windowSize + 1; i++) {
            int curMax = Integer.MIN_VALUE;
            //inner loop: right index tak pahunch rahe hai
            //each and every time : window prepeare :
            //left index: i
            //right index: i+windowSize-1
            for (int start = i; start < i + windowSize; start++) {
                curMax = Math.max(curMax, arr[start]);
            }
            result.add(curMax);
        }
        System.out.println(result.toString());
    }
}
