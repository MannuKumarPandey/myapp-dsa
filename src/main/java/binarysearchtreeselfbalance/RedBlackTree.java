package binarysearchtreeselfbalance;

public class RedBlackTree {

    private final Node TNULL; // Null leaf node
    private Node root;
    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.isRed = false;
        root = TNULL;
    }

    // Main method for testing
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("In-order traversal of the Red-Black Tree:");
        tree.inOrder();
    }

    // Left rotate
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != TNULL) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    // Right rotate
    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != TNULL) {
            x.right.parent = y;
        }

        x.parent = y.parent;

        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }

        x.right = y;
        y.parent = x;
    }

    // Fix violations after insertion
    private void fixInsert(Node k) {
        Node uncle;

        while (k.parent != null && k.parent.isRed) {
            if (k.parent == k.parent.parent.left) {
                uncle = k.parent.parent.right;

                // Case 1: Uncle is red
                if (uncle.isRed) {
                    k.parent.isRed = false;
                    uncle.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    // Case 2: Node is right child
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }

                    // Case 3: Node is left child
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    rightRotate(k.parent.parent);
                }
            } else {
                uncle = k.parent.parent.left;

                // Mirror cases
                if (uncle.isRed) {
                    k.parent.isRed = false;
                    uncle.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }

                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    leftRotate(k.parent.parent);
                }
            }
        }

        root.isRed = false;
    }

    // Insert a key into the Red-Black Tree
    public void insert(int key) {
        Node node = new Node(key);
        node.left = TNULL;
        node.right = TNULL;

        Node parent = null;
        Node current = root;

        while (current != TNULL) {
            parent = current;
            if (node.key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        node.parent = parent;

        if (parent == null) {
            root = node;
        } else if (node.key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        if (node.parent == null) {
            node.isRed = false; // Root must be black
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    // In-order traversal
    public void inOrder() {
        inOrderHelper(this.root);
        System.out.println();
    }

    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            System.out.print(node.key + " ");
            inOrderHelper(node.right);
        }
    }

    // Node class
    static class Node {
        int key;
        Node left, right, parent;
        boolean isRed;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.isRed = true; // New nodes are always red
        }
    }
}

