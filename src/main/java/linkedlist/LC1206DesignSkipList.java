package linkedlist;

import java.util.Random;

public class LC1206DesignSkipList {

    static final int MAX_LEVEL = 16; // Maximum level for the skiplist
    private final Node head;         // Head of the skiplist
    private final Random random;     // Random generator for level assignment
    private int currentLevel = 1;    // Current maximum level of the skiplist
    public LC1206DesignSkipList() {
        head = new Node(-1, MAX_LEVEL); // Head node with dummy value
        random = new Random();
    }

    public static void main(String[] args) {
        LC1206DesignSkipList skiplist = new LC1206DesignSkipList();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0)); // false
        System.out.println(skiplist.search(1)); // true
        skiplist.add(4);
        System.out.println(skiplist.search(4)); // true
        System.out.println(skiplist.erase(3));  // true
        System.out.println(skiplist.search(3)); // false
    }

    private int randomLevel() {
        int level = 1;
        while (random.nextInt(2) == 1 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public boolean search(int target) {
        Node current = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < target) {
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current != null && current.value == target;
    }

    public void add(int num) {
        Node current = head;
        Node[] update = new Node[MAX_LEVEL];
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < num) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        int level = randomLevel();
        if (level > currentLevel) {
            for (int i = currentLevel; i < level; i++) {
                update[i] = head;
            }
            currentLevel = level;
        }
        Node newNode = new Node(num, level);
        for (int i = 0; i < level; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node current = head;
        Node[] update = new Node[MAX_LEVEL];
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < num) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        current = current.forward[0];
        if (current == null || current.value != num) {
            return false;
        }
        for (int i = 0; i < currentLevel; i++) {
            if (update[i].forward[i] != current) {
                break;
            }
            update[i].forward[i] = current.forward[i];
        }
        while (currentLevel > 1 && head.forward[currentLevel - 1] == null) {
            currentLevel--;
        }
        return true;
    }

    // Node class to represent elements in the skiplist
    public static class Node {
        int value;
        Node[] forward;

        Node(int value, int level) {
            this.value = value;
            this.forward = new Node[level];
        }
    }


}
