package com.DataStructureAndAlgorithms.Queues;

import com.DataStructureAndAlgorithms.Employee;

public class Main {
    public static void main(String[] args) {
        arrayQueues();
    }

    public static void arrayQueues() {
        ArrayQueues queue = new ArrayQueues(10);

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marySmith);
        queue.add(mikeWilson);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.printQueue();
    }
}
