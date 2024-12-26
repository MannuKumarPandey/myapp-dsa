package doblyendedqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSlidingWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int pointerForResultStorage = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            /*yaha yah check kar rahe hai ki har ek moment par deque me deque ka peekFirst+k == i)
            matlab is bar ayi hui index ke liye deque ka first value k range se bahar ka hai
            matlab har ek moment par deque current index - k tak ki hi value rakhega.*/

            if (!deque.isEmpty() && deque.peekFirst() + k == i) {
                deque.pollFirst();
            }

            /*agar current index ki value deque ki last value se badi hai to deque ki last value ko hata dete hai qki
             aa rahi value hi max value banegi.
            matlab esa hai ki deque me hamesa left se right jate wakt increasing order me values rahegi.*/

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            //result ka value storage tab se start karenge i >= k-1 ho.
            if (i >= k - 1) {
                /*har ek moment par deque ka first element se jo index milega uske corresponding
                array ki value hi us sub array ki max value hogi.*/
                result[pointerForResultStorage++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
