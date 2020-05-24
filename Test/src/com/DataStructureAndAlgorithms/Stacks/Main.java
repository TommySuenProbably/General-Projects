package com.DataStructureAndAlgorithms.Stacks;

import com.DataStructureAndAlgorithms.Employee;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        linkedList();
    }

    public static void array() {
        ArrayStack stack = new ArrayStack(10);

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);

        stack.printStack();
    }

    public static void linkedList() {
        LinkedListStack stack = new LinkedListStack();

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);

        stack.printStack();
    }
}
