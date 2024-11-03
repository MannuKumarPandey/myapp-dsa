package CacheImplementation;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, ListNode> hm;
    ListNode head;
    ListNode tail;
    int count;
    int capacity;

    public LRUCache(int capacity) {
        hm = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);

        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;

        this.capacity = capacity; // capacity is used that this is the last number of objects can be present in
        // LRUCache
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    public int get(int key) {
        if (hm.get(key) != null) {
            ListNode temp = hm.get(key);
            int res = temp.value;

            deleteNode(temp);
            updateHead(temp);
            return res;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (hm.get(key) != null) {
            ListNode temp = hm.get(key);
            temp.value = value;
            deleteNode(temp);
            updateHead(temp);
        } else {
            ListNode newNode = new ListNode(key, value);
            hm.put(key, newNode);
            if (count < capacity) {
                count += 1;
                updateHead(newNode);
            } else {
                hm.remove(tail.prev.key);
                deleteNode(tail.prev);
                updateHead(newNode);
            }
        }
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void updateHead(ListNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    // Node Doubly Linked List
    public static class ListNode {

        int key;
        int value;
        ListNode prev;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
