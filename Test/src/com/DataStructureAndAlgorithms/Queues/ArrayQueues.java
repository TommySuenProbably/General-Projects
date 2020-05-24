//Interface: a class that describes behaviours of an abstract data type
/*
Bounded Blocked Array Queues are good for messaging between consumer & producer (RESTRICTED CAPACITY)
Producer: Adds a message
Consumer: Removes a message
If the producer attempts to add to the queue when the consumer has not removed a previous message, it will block.
If the consumer attempts to remove a message when the consumer has not added to the queue, it will block.
 */

package com.DataStructureAndAlgorithms.Queues;

import com.DataStructureAndAlgorithms.Employee;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueues {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueues(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if(size() == queue.length-1) {
            int numItems = size();
            Employee[] newArray = new Employee[2*queue.length];

            if(front <= back)
                System.arraycopy(queue, 0, newArray, 0, queue.length);
            else {
                System.arraycopy(queue, front, newArray, 0, queue.length-front);
                System.arraycopy(queue, 0, newArray, queue.length-front, back);
            }

            front = 0;
            back = numItems;
            queue = newArray;
        }

        queue[back] = employee;
        if(back < queue.length-1)
            back++;
        else
            back = 0;
        //My understanding of the wrap around
//        if(back == queue.length)
//            back = 0;
//        queue[back++] = employee;
    }

    public Employee remove() {
        if(isEmpty())
            throw new NoSuchElementException();

        Employee removedEmployee = queue[front];

        queue[front++] = null;
        if(isEmpty()) {
            front = 0;
            back = 0;
        }
        else if(front == queue.length)
            front = 0;
        return removedEmployee;
    }

    public Employee peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        return queue[front];
    }

    public Employee[] getQueue() {
        return queue;
    }

    public void setQueue(Employee[] queue) {
        this.queue = queue;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public int size() {
        if (front <= back)
            return back - front;
        return back - front + queue.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printQueue() {
        if(front <= back) {
            for (int index = front; index < back; index++)
                System.out.println(queue[index]);
        }
        else {
            for(int index = front; index < queue.length; index++)
                System.out.println(queue[index]);
            for(int index = 0; index < back; index++)
                System.out.println(queue[index]);
        }
    }
}
