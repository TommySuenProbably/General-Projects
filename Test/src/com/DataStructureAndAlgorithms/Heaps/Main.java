package com.DataStructureAndAlgorithms.Heaps;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] values = new int[] {25,20,15,27,30,29,26,22,32};

/*        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int value: values)
            heap.add(value);
        System.out.println(heap.peek());
        System.out.println(heap.toString());*/

        Heaps heap = new Heaps(10);

        for(int value: values)
            heap.insert(value);

//        Below use self-made heap class
        heap.printHeap();
        heap.getIndex(30);
        heap.delete(30);
        heap.printHeap();
        System.out.println(heap.peek());
        heap.delete(32);
        heap.printHeap();
        System.out.println(heap.peek());
        heap.sort();
    }
}


