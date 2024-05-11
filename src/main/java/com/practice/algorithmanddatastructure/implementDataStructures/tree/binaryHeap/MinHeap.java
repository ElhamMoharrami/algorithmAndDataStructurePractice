package com.practice.algorithmanddatastructure.implementDataStructures.tree.binaryHeap;

public class MinHeap {
    // To store array of elements in heap
    private final int[] heapArray;

    // max size of the heap
    private final int capacity;

    // Current number of elements in the heap
    private int current_heap_size;

    // Constructor
    public MinHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

    // Swapping using reference
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Get the Parent index for the given index
    private int parent(int key) {
        return (key - 1) / 2;
    }

    // Get the Left Child index for the given index
    private int left(int key) {
        return 2 * key + 1;
    }

    // Get the Right Child index for the given index
    private int right(int key) {
        return 2 * key + 2;
    }

    public boolean insert(int key) {
        if (current_heap_size == capacity) {
            System.out.println("heap is full");
            return false;
        }
        //first insert the new key at the end
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        //fix min heap property if violated
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }

        return true;
    }

    // Returns the minimum key (key at
    // root) from min heap
    public int getMin() {
        return heapArray[0];
    }

    public int extractMin() {
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        if (current_heap_size == 1) {
            current_heap_size--;
            return heapArray[0];
        }

        int root = heapArray[0];
        //replace root with last element
        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        minHeapify(0);
        return root;
    }

    // A recursive method to heapify a subtree
    // with the root at given index
    // This method assumes that the subtrees
    // are already heapified
    private void minHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
            smallest = l;
        }
        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
            smallest = r;
        }

        if (smallest != key) {
            swap(heapArray, key, smallest);
            minHeapify(smallest);
        }
    }

    class MinHeapTest {
        public static void main(String[] args) {
            MinHeap h = new MinHeap(11);
            h.insert(3);
            h.insert(2);
            h.insert(1);
            h.insert(15);
            h.insert(5);
            h.insert(4);
            h.insert(45);
            System.out.print(h.extractMin() + " ");
            System.out.print(h.getMin() + " ");
            System.out.print(h.getMin());
        }
    }
}
