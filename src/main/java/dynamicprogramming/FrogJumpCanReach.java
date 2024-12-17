package dynamicprogramming;


import java.util.*;

class FrogJumpCanReach {

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

    public static boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        // Create a HashMap to store possible jump lengths for each stone
        Map<Integer, Set<Integer>> stoneMap = new HashMap<>();
        for (int stone : stones) {
            stoneMap.put(stone, new HashSet<>());
        }
        // The first stone has an initial jump length of 0

        //0 tum tak mai pahuncha hu 0 step lekar
        stoneMap.get(stones[0]).add(0);


        // Process each stone
        for (int stone : stones) {
            //stone ane wali set ki values ye batayegi ki tum, tak pahuchane ke liye kaun kaun se step liye gaye the
            Set<Integer> jumps = stoneMap.get(stone);
            for (int jump : jumps) {
                // Calculate possible next jumps
                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
                    if (nextJump > 0 && stoneMap.containsKey(stone + nextJump)) {
                        // Add the next jump length to the next stone's set
                        stoneMap.get(stone + nextJump).add(nextJump);
                    }
                }
            }
        }

        // Check if the last stone has any jump lengths
        return !stoneMap.get(stones[stones.length - 1]).isEmpty();
    }

}