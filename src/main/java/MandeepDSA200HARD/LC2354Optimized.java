package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class LC2354Optimized {

    public static void main(String[] args) {
        System.out.println(countExcellentPairs(new int[]{1, 2, 3, 1}, 3));
    }

    public static long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        //uniqueNums : 1 2 3

        List<Integer> bitCounts = new ArrayList<>();
        for (int num : uniqueNums) {
            bitCounts.add(Integer.bitCount(num));
        }

        Collections.sort(bitCounts);

        long count = 0;
        int n = bitCounts.size();

        for (int x : bitCounts) {
            int idx = lowerBound(bitCounts, k - x);
            count += (n - idx);
        }

        return count;
    }

    private static int lowerBound(List<Integer> bitCounts, int target) {
        int left = 0, right = bitCounts.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (bitCounts.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

