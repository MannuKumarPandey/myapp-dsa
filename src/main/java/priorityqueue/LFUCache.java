package priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LFUCache {

    public static void main(String[] args) {

        // Create an LFUCache with a capacity of 2
        LFUCache lfuCache = new LFUCache(2);

        // Test 1: Put values into the cache
        lfuCache.put(1, 1); // Cache is {1=1}
        lfuCache.put(2, 2); // Cache is {1=1, 2=2}

        // Test 2: Get value
        System.out.println(lfuCache.get(1)); // Returns 1, Cache is {2=2, 1=1}

        // Test 3: Update frequency
        lfuCache.put(3, 3); // Evicts key 2 (least frequently used), Cache is {1=1, 3=3}

        // Test 4: Get value
        System.out.println(lfuCache.get(2)); // Returns -1 (not found)

        // Test 5: Get value
        System.out.println(lfuCache.get(3)); // Returns 3, Cache is {1=1, 3=3}

        // Test 6: Update frequency
        lfuCache.put(4, 4); // Evicts key 1, Cache is {3=3, 4=4}

        // Test 7: Get value
        System.out.println(lfuCache.get(1)); // Returns -1 (not found)

        // Test 8: Get value
        System.out.println(lfuCache.get(3)); // Returns 3, Cache is {3=3, 4=4}

        // Test 9: Get value
        System.out.println(lfuCache.get(4)); // Returns 4, Cache is {3=3, 4=4}
    }

    private class Node {
        int key, value, frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // start with frequency of 1
        }
    }

    private Map<Integer, Node> cache; // Maps key to Node
    private Map<Integer, PriorityQueue<Node>> frequencyMap; // Maps frequency to a min-heap of Nodes
    private int minFrequency; // Track the minimum frequency
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.minFrequency = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }

        Node node = cache.get(key);
        updateNodeFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (cache.containsKey(key)) {
            // Update the value and frequency
            Node node = cache.get(key);
            node.value = value;
            updateNodeFrequency(node);
        } else {
            if (cache.size() >= capacity) {
                // Remove the least frequently used node
                removeLeastFrequentlyUsed();
            }
            // Add new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            frequencyMap.putIfAbsent(1, new PriorityQueue<>((a, b) -> a.key - b.key));
            frequencyMap.get(1).offer(newNode);
            minFrequency = 1;
        }
    }

    private void updateNodeFrequency(Node node) {
        // Remove from current frequency list
        int oldFrequency = node.frequency;
        frequencyMap.get(oldFrequency).remove(node);

        // Update node frequency
        node.frequency++;

        // Add to the new frequency list
        frequencyMap.putIfAbsent(node.frequency, new PriorityQueue<>((a, b) -> a.key - b.key));
        frequencyMap.get(node.frequency).offer(node);

        // If the old frequency list is empty, update minFrequency
        if (frequencyMap.get(oldFrequency).isEmpty()) {
            frequencyMap.remove(oldFrequency);
            if (oldFrequency == minFrequency) {
                minFrequency++;
            }
        }
    }

    private void removeLeastFrequentlyUsed() {
        PriorityQueue<Node> minFreqQueue = frequencyMap.get(minFrequency);
        if (minFreqQueue != null && !minFreqQueue.isEmpty()) {
            Node lfuNode = minFreqQueue.poll();
            cache.remove(lfuNode.key);
            if (minFreqQueue.isEmpty()) {
                frequencyMap.remove(minFrequency);
            }
        }
    }
}

