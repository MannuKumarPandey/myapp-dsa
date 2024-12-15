package priorityqueue;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2,2}}, 2));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        //0th index par gain rakhe hai
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double sum = 0.0;

        // Initialize the heap with gains and add the initial ratios to sum
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double currentRatio = (double) pass / total;

            //gain ka matlab yah hai ki ane wale moments me agar is class ke sath 1 add kare to gain kitna hoga
            //agar iska gain jyada hoga matlab isi me add karenge
            //jiska gain jyada hoga whi final output me jyada contribute karega
            double gain = ((double) (pass + 1) / (total + 1)) - currentRatio;

            //jo current ka ratio hai usko result me add kar dete hai
            sum += currentRatio;
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Distribute extra students to maximize the average ratio
        //har bar sirf ek ek student ko hi add karke check karenge tab jakar final answer maximized hoga.
        for (int i = 0; i < extraStudents; i++) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int pass = (int) top[1];
            int total = (int) top[2];

            // Update the sum by removing the old ratio and adding the new one
            sum -= (double) pass / total;
            pass++;
            total++;
            sum += (double) pass / total;

            // Recalculate the gain and push back into the heap
            double newGain = ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
            maxHeap.offer(new double[]{newGain, pass, total});
        }

        // Return the final average
        return sum / classes.length;
    }
}
