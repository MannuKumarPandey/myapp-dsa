package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC493ReversePairsDifferentway {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
    }


    public static int reversePairs(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int a : nums) {
            list.add(a);
        }
        Collections.sort(list);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            list = dbs(list, num);
            int target = (int) Math.ceil(num / 2);
            count += bs(list, target);
        }
        return count;

    }


    public static int bs(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static List<Integer> dbs(List<Integer> list, int num) {
        int l = 0;
        int h = list.size() - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (list.get(mid) == num) {
                list.remove(mid);
                break;
            } else if (list.get(mid) > num) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return list;
    }

}
