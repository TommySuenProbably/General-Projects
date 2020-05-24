package com.DataStructureAndAlgorithms.Stacks;

import com.DataStructureAndAlgorithms.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListStack {
    private LinkedList<Employee> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Employee> iter = stack.listIterator();

        while(iter.hasNext())
            System.out.println(iter.next());
    }
}
