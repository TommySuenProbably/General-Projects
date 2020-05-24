//Heapsort included in class
/*
Heaps are binary trees that complete two conditions:
1) It must be a complete binary tree
2) Heap Property (Max OR Min)
   Parents either are >=
                      <= Children (CONFUSING: Normal binary trees push less than to left, more than to right

Binary trees must "heapified" and heaps must be heapified after insertion/deletion.
*/

package com.DataStructureAndAlgorithms.Heaps;

import java.util.Arrays;

import static com.DataStructureAndAlgorithms.SearchAlgorithms.Main.linearSearch;

public class Heaps {
    private int[] heap;
    int size;

    public Heaps(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public void sort() {
        for(int i = 0; i < size-2; i++) {
            int bound = size-1 - i;

            System.out.println(bound);
            if(i != 0)
                heapifyBelow(0,bound);

            swap(0,bound);
        }
        printHeap();
    }

    public void insert(int value) {
        if(isFull())
            resize();

        heap[size++] = value;
        heapifyAbove(size-1); //Arguably not good; just increment after the operation
    }

    public void delete(int value) {
        int index = getIndex(value);

        if(index == -1 || index >= size)
            throw new ArrayIndexOutOfBoundsException();

        //if(index == size-1), DO NOTHING. A heap is supposed to only take the top value anyway
        //I don't know how to handle it. I guess size-- eliminates its existence anyway.

        heap[index] = heap[size - 1];
        if(index != 0 || heap[index] > heap[getParentIndex(index)])
            heapifyAbove(index);
        heapifyBelow(index,size-1);

        size--; //Again, if index is the last of the heap, it will be eliminated
    }

    public int peek() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("No heap.");
        return heap[0];
    }

    //Parent = Math.floor((index-1)/2) <- ints automatically truncate, no need for floor
    //Left Child = 2*index + 1
    //Right Child = 2*index + 2
    public void heapifyAbove(int index) {
        int value = heap[index];

        while(index > 0 && value > heap[getParentIndex(index)]) {
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }
        heap[index] = value;
    }

    public void heapifyBelow(int index, int lastIndex) {
        int leftChildIndex = getChildIndex(index,true);
        int rightChildIndex = getChildIndex(index,false);

        int greaterChildIndex = -1;
        if(leftChildIndex > lastIndex && rightChildIndex > lastIndex)
            return;
        else if(leftChildIndex <= lastIndex && rightChildIndex > lastIndex)
            greaterChildIndex = leftChildIndex;
        else
            greaterChildIndex = (heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex);

        if(greaterChildIndex == -1) throw new ArrayIndexOutOfBoundsException();

        if(heap[greaterChildIndex] > heap[index]) {
            swap(greaterChildIndex,index);
            heapifyBelow(greaterChildIndex,lastIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];

        heap[i] = heap[j];
        heap[j] = temp;
    }

    //DANG IT, binary search has to be sorted
    public int getIndex(int value) {
        return linearSearch(heap,value); //From package: Search Algorithms
    }

    public int getParentIndex(int index) {
        return (index-1)/2;
    }

    //This was my original. The combined method uses a ternary operator BUT uses a boolean
//    public int getLeftChildIndex(int index) {
//        int childIndex = 2*index + 1;
//
//        if(childIndex >= heap.length)
//            return -1;
//        return childIndex;
//    }
//
//    public int getRightChildIndex(int index) {
//        int childIndex = 2*index + 2;
//
//        if(childIndex >= heap.length)
//            return -1;
//        return childIndex;
//    }

    public int getChildIndex(int index, boolean left) {
        return 2*index + (left ? 1 : 2);
    }

    public void resize() {
        int[] newArray = new int[2*heap.length];

        System.arraycopy(heap,0,newArray,0,heap.length);
        heap = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }
}
