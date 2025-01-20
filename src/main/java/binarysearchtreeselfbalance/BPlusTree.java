package binarysearchtreeselfbalance;

import java.util.ArrayList;
import java.util.List;

public class BPlusTree {
    private final int degree; // Minimum degree (defines the range of the number of keys)
    private Node root;
    public BPlusTree(int degree) {
        this.root = new Node(true); // Initialize with an empty leaf node
        this.degree = degree;
    }

    // Main method for testing
    public static void main(String[] args) {
        BPlusTree tree = new BPlusTree(3); // Minimum degree of 3

        // Insert keys into the B+ Tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        System.out.println("B+ Tree structure:");
        tree.printTree();

        System.out.println("\nKeys in sorted order:");
        tree.printSorted();

        System.out.println("\nSearch for key 12: " + (tree.search(12) ? "Found" : "Not Found"));
        System.out.println("Search for key 15: " + (tree.search(15) ? "Found" : "Not Found"));
    }

    // Search for a key in the B+ Tree
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        int i = 0;

        // Find the first key greater than or equal to the search key
        while (i < node.keys.size() && key > node.keys.get(i)) {
            i++;
        }

        if (node.isLeaf) {
            // Check if the key exists in the leaf node
            return i < node.keys.size() && node.keys.get(i) == key;
        }

        // Recur to the appropriate child
        return search(node.children.get(i), key);
    }

    // Insert a key into the B+ Tree
    public void insert(int key) {
        Node oldRoot = root;

        if (oldRoot.keys.size() == 2 * degree - 1) {
            // If the root is full, split it and create a new root
            Node newRoot = new Node(false);
            newRoot.children.add(oldRoot);
            splitChild(newRoot, 0, oldRoot);
            root = newRoot;
        }

        insertNonFull(root, key);
    }

    private void insertNonFull(Node node, int key) {
        if (node.isLeaf) {
            // Insert the key into the correct position in the leaf node
            int i = node.keys.size() - 1;
            while (i >= 0 && key < node.keys.get(i)) {
                i--;
            }
            node.keys.add(i + 1, key);
        } else {
            // Find the child to which the key should be added
            int i = node.keys.size() - 1;
            while (i >= 0 && key < node.keys.get(i)) {
                i--;
            }
            i++;

            Node child = node.children.get(i);
            if (child.keys.size() == 2 * degree - 1) {
                // Split the child if it's full
                splitChild(node, i, child);

                // Determine the correct child to insert the key
                if (key > node.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(node.children.get(i), key);
        }
    }

    private void splitChild(Node parent, int index, Node fullChild) {
        Node newChild = new Node(fullChild.isLeaf);
        int medianIndex = degree - 1;

        // Move the last (degree - 1) keys to the new child
        for (int i = 0; i < degree - 1; i++) {
            newChild.keys.add(fullChild.keys.remove(medianIndex));
        }

        if (!fullChild.isLeaf) {
            // Move the last (degree) children to the new child
            for (int i = 0; i < degree; i++) {
                newChild.children.add(fullChild.children.remove(medianIndex + 1));
            }
        } else {
            // Maintain the linked list of leaf nodes
            newChild.next = fullChild.next;
            fullChild.next = newChild;
        }

        // Insert the median key into the parent node
        parent.keys.add(index, fullChild.keys.remove(medianIndex));
        parent.children.add(index + 1, newChild);
    }

    // Print the B+ Tree
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        System.out.println("Level " + level + ": " + node.keys);

        if (!node.isLeaf) {
            for (Node child : node.children) {
                printTree(child, level + 1);
            }
        }
    }

    // Print all keys in sorted order (traverse the leaf nodes)
    public void printSorted() {
        Node current = root;
        while (!current.isLeaf) {
            current = current.children.get(0);
        }

        while (current != null) {
            System.out.println(current.keys);
            current = current.next;
        }
    }

    // Node class
    static class Node {
        List<Integer> keys;         // Keys stored in the node
        List<Node> children;        // Pointers to child nodes
        boolean isLeaf;             // True if the node is a leaf
        Node next;                  // Pointer to the next leaf node (for leaf nodes only)

        Node(boolean isLeaf) {
            this.isLeaf = isLeaf;
            this.keys = new ArrayList<>();
            this.children = new ArrayList<>();
            this.next = null;
        }
    }
}
