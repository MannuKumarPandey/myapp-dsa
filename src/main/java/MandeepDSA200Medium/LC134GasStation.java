package MandeepDSA200Medium;

public class LC134GasStation {


    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int result = canCompleteCircuit(gas, cost);
        System.out.println("Starting Station: " + result);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startStation = 0;


        for (int i = 0; i < gas.length; i++) {
            totalGas = totalGas+gas[i];
            totalCost = totalCost +cost[i];

            currentGas = currentGas + gas[i] - cost[i];

            if (currentGas < 0) {
                startStation = i + 1; // Reset starting station
                currentGas = 0;       // Reset currentGas
            }
        }

        // If totalGas < totalCost, completing the circuit is impossible
        return totalGas >= totalCost ? startStation : -1;
    }


}
