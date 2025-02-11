package MandeepDSA200HARD;

import java.util.*;

class LC1439KthSmallestSumOfMatrix {

    public static void main(String[] args) {
        LC1439KthSmallestSumOfMatrix solver = new LC1439KthSmallestSumOfMatrix();

        int[][] mat1 = {
                {1, 3, 11},
                {2, 4, 6}
        };
        int k1 = 5;
        System.out.println("Kth Smallest Sum: " + solver.kthSmallest(mat1, k1)); // Expected output: 17

    }


    private int[] combine(int sum, int[] indices) {
        int[] arr = new int[indices.length + 1];
        arr[0] = sum;
        System.arraycopy(indices, 0, arr, 1, indices.length);
        return arr;
    }

    public int kthSmallest(int[][] mat, int k) {
        int row = mat.length, column = mat[0].length;

        // Min-Heap storing sum and index array
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initial sum of choosing the first element(0th index) from each row
        int sum = 0;
        int[] indices = new int[row];
        for (int i = 0; i < row; i++) {
            sum += mat[i][0];
        }

        pq.offer(combine(sum, indices)); // Properly formatted
        Set<String> seen = new HashSet<>();
        seen.add(Arrays.toString(indices));

        while (k-- > 0) {
            int[] curr = pq.poll();
            sum = curr[0];
            indices = Arrays.copyOfRange(curr, 1, row + 1);

            // If it's the k-th extracted, return the sum
            if (k == 0) return sum;

            // Generate next states by increasing one row index at a time
            for (int i = 0; i < row; i++) {
                if (indices[i] + 1 < column) {
                    int[] newIndices = Arrays.copyOf(indices, row);
                    newIndices[i]++;  // Move to the next element in row i
                    int newSum = sum - mat[i][indices[i]] + mat[i][newIndices[i]];

                    String key = Arrays.toString(newIndices);
                    if (!seen.contains(key)) {
                        seen.add(key);
                        pq.offer(combine(newSum, newIndices));
                    }
                }
            }
        }
        return -1;
    }


}


