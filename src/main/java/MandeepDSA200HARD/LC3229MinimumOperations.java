package MandeepDSA200HARD;

class LC3229MinimumOperations {

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{3, 5, 1, 2}, new int[]{4, 6, 2, 4}));

        System.out.println(minimumOperations(new int[]{1,3,2}, new int[]{2,1,4}));
    }

    public static long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = target[i] - nums[i];
        }


        long totalJump = Math.abs(diff[0]);
        for (int i = 1; i < n; i++) {
            totalJump += Math.abs(diff[i] - diff[i - 1]); // jump between diff[i-1] and diff[i]
        }
       // totalJump += Math.abs(diff[n - 1]); // jump at the right boundary

        // Step 3: Each operation can fix 2 units of jump (one at each end),
        // so the answer is half the total jump.
        return totalJump ;
    }
}