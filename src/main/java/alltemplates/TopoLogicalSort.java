package alltemplates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoLogicalSort {
    public List<Integer> topologicalSort(int numNodes, List<List<Integer>> graph) {
        int[] inDegree = new int[numNodes];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Compute in-degrees of all nodes
        for (int i = 0; i < numNodes; i++) {
            for (int neighbor : graph.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Add all nodes with in-degree 0 to the queue
        for (int i = 0; i < numNodes; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.size() != numNodes) {
            throw new IllegalArgumentException("Graph has a cycle!");
        }

        return result;
    }
}
