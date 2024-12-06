package priorityqueue;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(1);
        minHeap.insert(8);
        minHeap.insert(9);

        System.out.println("Heap elements:");
        minHeap.printHeap();

        System.out.println("Extracted min: " + minHeap.extractMin());
        System.out.println("Heap after extracting min:");
        minHeap.printHeap();
    }

    // Get index of parent, left child, and right child
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Check if a node has left or right child
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    // Swap two elements in the heap
    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    // Ensure the heap has enough space
    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    // Insert a new element into the heap
    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }

    // Heapify up to maintain min-heap property
    private void heapifyUp() {
        int index = size - 1; // Start from the last inserted element
        while (index > 0 && heap[getParentIndex(index)] > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    // Extract the minimum element (root) from the heap
    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return min;
    }

    // Heapify down to maintain min-heap property
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heap[getRightChildIndex(index)] < heap[smallerChildIndex]) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] <= heap[smallerChildIndex]) {
                break; // If parent is smaller than both children, stop
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    // Display the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Get the size of the heap
    public int getSize() {
        return size;
    }
}

