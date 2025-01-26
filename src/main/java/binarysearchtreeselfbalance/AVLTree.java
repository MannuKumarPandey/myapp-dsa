package binarysearchtreeselfbalance;

public class AVLTree {

    private Node root;


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        // Print in-order traversal
        System.out.println("In-order traversal of the AVL tree:");
        tree.inOrder();
    }

    // Get the height of the node
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Get the balance factor of the node
    private int getBalanceFactor(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with y
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node backupSubTrees = x.right;

        // yha rotation ho rahi hai
        x.right = y;
        y.left = backupSubTrees;

        // y and x dono nodes ki heights ko update kar rahe hai
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node backupSubTrees = y.left;

        // yha rotation ho rahi hai
        y.left = x;
        x.right = backupSubTrees;

        // y and x dono nodes ki heights ko update kar rahe hai
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a key into the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        //Step 1)  Perform the normal BST insertion
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Agar koi duplicate key insert hone aa nahi hai to usko allow nahi karenge
            return node;
        }

        //step 2)  Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Step 3) Get the balance factor
        int balance = getBalanceFactor(node);

        //step 4) If the node becomes unbalanced, there are 4 cases:

        // Left Left Case---Means Tree Left Left heavy hai --> means right side rotate karna padega
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right Right Case------Means Tree Right Right heavy hai --> means Left side rotate karna padega
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Case---> Left Right case two steps ke rotations ka  steps hai.
        // pahle right rotation karne ke bad fir left rotation karenge
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case---> Right Left case two steps ke rotations ka  steps hai.
        // pahle left rotation karne ke bad fir right rotation karenge
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the unchanged node
    }

    // Print the tree in-order
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }


    static class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            height = 1;
        }
    }
}
