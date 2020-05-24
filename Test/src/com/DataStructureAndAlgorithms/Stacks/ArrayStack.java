package com.DataStructureAndAlgorithms.Stacks;

import com.DataStructureAndAlgorithms.Employee;

import java.util.EmptyStackException;

public class ArrayStack {
    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
        top = 0;
    }

    public void push(Employee employee) {
        if(top == stack.length) {
            Employee[] newArray = new Employee[2*stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = employee;
    }

    public Employee pop() {
        //For diligence
//        if(top < stack.length/2){
//            Employee[] newArray = new Employee[stack.length/2];
//            System.arraycopy(stack, 0, newArray, 0, top-1);
//            stack = newArray;
//        }

        if(isEmpty())
            throw new EmptyStackException();
        Employee removedEmployee = stack[--top];
        stack[top] = null;
        return removedEmployee;
    }

    public Employee peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack[top-1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for(int i = top-1; i >= 0; i--)
            System.out.println(stack[i]);
    }
}
