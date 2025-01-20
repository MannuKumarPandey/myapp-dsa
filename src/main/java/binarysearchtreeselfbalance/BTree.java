package binarysearchtreeselfbalance;

public class BTree {

    private Node root;
    private int degree; // Minimum degree
    public BTree(int degree) {
        this.root = null;
        this.degree = degree;
    }

    // Main method for testing
    public static void main(String[] args) {
        BTree tree = new BTree(3); // Minimum degree of 3 (2-3 tree)

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        System.out.println("B-Tree structure:");
        tree.printTree();
    }

    // Search for a key in the B-Tree
    public Node search(int key) {
        return root == null ? null : search(root, key);
    }

    private Node search(Node node, int key) {
        int i = 0;

        // Find the first key greater than or equal to the key
        while (i < node.numKeys && key > node.keys[i]) {
            i++;
        }

        // If the key is found, return the node
        if (i < node.numKeys && node.keys[i] == key) {
            return node;
        }

        // If the node is a leaf, the key is not in the tree
        if (node.isLeaf) {
            return null;
        }

        // Otherwise, search the appropriate child
        return search(node.children[i], key);
    }

    // Insert a key into the B-Tree
    public void insert(int key) {
        if (root == null) {
            // Tree is empty, create a new root
            root = new Node(degree, true);
            root.keys[0] = key;
            root.numKeys = 1;
        } else {
            // Root is full, need to split
            if (root.numKeys == 2 * degree - 1) {
                Node newRoot = new Node(degree, false);
                newRoot.children[0] = root;
                splitChild(newRoot, 0, root);
                root = newRoot;
                insertNonFull(root, key);
            } else {
                insertNonFull(root, key);
            }
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.numKeys - 1;

        if (node.isLeaf) {
            // Find the position to insert the new key
            while (i >= 0 && node.keys[i] > key) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numKeys++;
        } else {
            // Find the child to which the key should be added
            while (i >= 0 && node.keys[i] > key) {
                i--;
            }
            i++;

            if (node.children[i].numKeys == 2 * degree - 1) {
                // Split the child if it's full
                splitChild(node, i, node.children[i]);
                if (key > node.keys[i]) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(Node parent, int i, Node fullChild) {
        Node newChild = new Node(degree, fullChild.isLeaf);
        newChild.numKeys = degree - 1;

        // Copy the last (degree - 1) keys from fullChild to newChild
        for (int j = 0; j < degree - 1; j++) {
            newChild.keys[j] = fullChild.keys[j + degree];
        }

        if (!fullChild.isLeaf) {
            // Copy the last degree children from fullChild to newChild
            for (int j = 0; j < degree; j++) {
                newChild.children[j] = fullChild.children[j + degree];
            }
        }

        fullChild.numKeys = degree - 1;

        // Make space for the new child in the parent node
        for (int j = parent.numKeys; j >= i + 1; j--) {
            parent.children[j + 1] = parent.children[j];
        }
        parent.children[i + 1] = newChild;

        // Move the middle key from fullChild to the parent node
        for (int j = parent.numKeys - 1; j >= i; j--) {
            parent.keys[j + 1] = parent.keys[j];
        }
        parent.keys[i] = fullChild.keys[degree - 1];
        parent.numKeys++;
    }

    // Print the tree in a hierarchical structure
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            for (int i = 0; i < node.numKeys; i++) {
                System.out.print(node.keys[i] + (i < node.numKeys - 1 ? ", " : ""));
            }
            System.out.println();
            for (int i = 0; i <= node.numKeys; i++) {
                printTree(node.children[i], indent, i == node.numKeys);
            }
        }
    }

    private static class Node {
        int[] keys;
        int degree; // Minimum degree (defines the range for the number of keys)
        Node[] children;
        int numKeys; // Current number of keys
        boolean isLeaf;

        Node(int degree, boolean isLeaf) {
            this.degree = degree;
            this.isLeaf = isLeaf;
            this.keys = new int[2 * degree - 1]; // Maximum keys a node can hold
            this.children = new Node[2 * degree]; // Maximum children a node can have
            this.numKeys = 0;
        }
    }
}

