package MandeepDSA200HARD;

import java.util.Arrays;

public class LC1665MinimumEnergyToCOmpleteTasks {

    public static void main(String[] args) {


        //                                            {minimum, actual}
        System.out.println(minimumEffort(new int[][]{{1, 2}, {2, 4}, {4, 8}}));
    }

    public static int minimumEffort(int[][] tasks) {
        // Sort tasks based on the difference (minimum energy - actual cost) in descending order
        //This ensures that tasks with high minimum required energy get scheduled earlier to prevent sudden energy shortages.
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0])); //n logn

        int totalLagiHuiEnergy = 0;
        int currentEnergyJoAbhiHai = 0;

        // Iterate through tasks and calculate the required initial energy
        for (int[] task : tasks) {
            int actualCost = task[0];
            int minRequired = task[1];

            if (currentEnergyJoAbhiHai < minRequired) {
                totalLagiHuiEnergy += (minRequired - totalLagiHuiEnergy);
                currentEnergyJoAbhiHai = minRequired - actualCost;
            } else {
                currentEnergyJoAbhiHai = currentEnergyJoAbhiHai - actualCost;
            }
        }

        return totalLagiHuiEnergy;
    }
}
