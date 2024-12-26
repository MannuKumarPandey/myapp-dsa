package priorityqueue;

import java.util.Arrays;

public class MaxHeap {

    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize heap
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        this.heap = new int[capacity];
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(8);
        maxHeap.insert(9);

        System.out.println("Heap elements:");
        maxHeap.printHeap();

        System.out.println("Extracted max: " + maxHeap.extractMax());
        System.out.println("Heap after extracting max:");
        maxHeap.printHeap();
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

    // jaise hi inserted elements ki size maximum capacity ke barabar hogi
    //capacity ko double kar diya jayega aur unke sare elements ko bi newly created array me copy kar denge
    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    // Insert a new element into the heap
    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;// size wo pointer hai jo last me point karega jha newly added element ko rakhna hai
        size++;
        heapifyUp(); //add karne ke bad heapify call karna hai
    }

    // Heapify up to maintain max-heap property
    private void heapifyUp() {
        int index = size - 1;

         /*Start from the last inserted element
        matlab jab ham newly added element add kiye tab usko us added index ke parent part ki valuye se
        check karenge ki wo usase bada hai kya , agar esa hota hai tab usko swap karte chalenge ,
        esa tabtak karenge jabtak ki added value root tak na pahuch jaye agar bada hota gya tab.*/


        while (index > 0 && heap[getParentIndex(index)] < heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /* Extract the maximum element (root) from the heap
   Jab ham extract masx from root kar lenge tab heapifyDown ko call karenge ki second max ab
   root position par aa jaye. */
    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        // means heap[0] matlab root element size-1 (last) position wale se replace ho gya.
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return max;
    }

    // Heapify down to maintain max-heap property
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) { //left child 2*index+1 position par hoga
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heap[getRightChildIndex(index)] > heap[largerChildIndex]) {
                largerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] >= heap[largerChildIndex]) {
                break; // If parent is larger than both children, stop
            }
            swap(index, largerChildIndex);
            index = largerChildIndex;
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
