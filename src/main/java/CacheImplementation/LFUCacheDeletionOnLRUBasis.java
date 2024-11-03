package CacheImplementation;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCacheDeletionOnLRUBasis {


    public static void main(String[] args) {
        LFUCacheDeletionOnLRUBasis lfuCache = new LFUCacheDeletionOnLRUBasis(3); // Set the cache capacity to 3

        // Test put operations
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);

        System.out.println(lfuCache.get(1)); // Expected output: 1
        System.out.println(lfuCache.get(2)); // Expected output: 2

        // Access key 1 again to increase its frequency
        System.out.println(lfuCache.get(1)); // Expected output: 1

        // Add a new element, which should evict the least frequently used key
        lfuCache.put(4, 4);

        // Since key 3 is the least frequently used, it should be evicted
        System.out.println(lfuCache.get(3)); // Expected output: -1 (evicted)
        System.out.println(lfuCache.get(4)); // Expected output: 4
        System.out.println(lfuCache.get(1)); // Expected output: 1

        // Add another element to test eviction order
        lfuCache.put(5, 5);

        // Now key 2 should be evicted because it has the least frequency
        System.out.println(lfuCache.get(2)); // Expected output: -1 (evicted)
        System.out.println(lfuCache.get(5)); // Expected output: 5
    }
    private final int capacity;
    // Stores the key-value pairs
    private final Map<Integer, Integer> cache = new HashMap<>();
    // Stores the frequency of each key
    private final Map<Integer, Integer> frequencyMap = new HashMap<>();
    // Stores lists of keys for each frequency
    private final Map<Integer, LinkedHashSet<Integer>> frequencyListMap = new HashMap<>();
    private int minFrequency = 1; // Track the minimum frequency in the cache

    public LFUCacheDeletionOnLRUBasis(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not present
        }
        updateFrequency(key); // Update the frequency since this key was accessed
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return; // No space in cache

        if (cache.containsKey(key)) {
            cache.put(key, value); // Update value
            updateFrequency(key); // Update frequency for this access
        } else {
            // If cache is full, evict the least frequently used item
            if (cache.size() >= capacity) {
                deleteLeastRecentlyUsedNode();
            }
            // Add the new key-value pair
            cache.put(key, value);
            frequencyMap.put(key, 1); // Initial frequency is 1
            minFrequency = 1; // Reset min frequency for new item
            frequencyListMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        }
    }

    private void updateFrequency(int key) {
        int currentFreq = frequencyMap.get(key);
        frequencyMap.put(key, currentFreq + 1); // Increase frequency

        // Remove key from current frequency list
        frequencyListMap.get(currentFreq).remove(key);

        // If current frequency list is empty and it was the minimum, increase min frequency
        if (currentFreq == minFrequency && frequencyListMap.get(currentFreq).isEmpty()) {
            minFrequency++;
        }

        // Add key to the new frequency list
        frequencyListMap.computeIfAbsent(currentFreq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    private void deleteLeastRecentlyUsedNode() {
        // Get the keys in the minimum frequency list
        LinkedHashSet<Integer> keys = frequencyListMap.get(minFrequency);

        // Evict the least recently used key within the minimum frequency list
        int evictKey = keys.iterator().next(); // Get the first item (LRU)
        keys.remove(evictKey); // Remove it from the frequency list

        if (keys.isEmpty()) {
            frequencyListMap.remove(minFrequency); // Clean up if empty
        }

        cache.remove(evictKey); // Remove from main cache
        frequencyMap.remove(evictKey); // Remove frequency record
    }
}
