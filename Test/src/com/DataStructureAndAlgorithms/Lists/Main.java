//Backing array - unknown term?
package com.DataStructureAndAlgorithms.Lists;

import com.DataStructureAndAlgorithms.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    private static void exampleCodeOfList() {
        List<Employee> employeeList =  new ArrayList<>(); //Default capacity: 10

        employeeList.add(new Employee("Jane","Jones",123));
        employeeList.add(new Employee("John","Doe",4567));
        employeeList.add(new Employee("Mary","Smith",22));
        employeeList.add(new Employee("Mike","Wilson", 3245));

        //employeeList.forEach(employee -> System.out.println(employee));
        //System.out.println(employeeList.get(2)); //This is the third employee in the list

        employeeList.set(1, new Employee("John","Adams",4568));
        //System.out.println(employeeList.get(1));

        //System.out.println(employeeList.isEmpty());
        //System.out.println(employeeList.size());

        employeeList.add(3, new Employee("John","Doe",4567));
        //employeeList.forEach(employee -> System.out.println(employee));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for(Employee employee: employeeArray)
            System.out.println(employee);

        System.out.println(employeeList.contains(new Employee("John","Doe",4567)));
        System.out.println(employeeList.indexOf(new Employee("John","Doe",4567)));
    }

    public static void linkedList() {
        LinkedList<Employee> employeeLinkedList = new LinkedList<>();

        employeeLinkedList.addFirst(new Employee("Jane","Jones",123));
        employeeLinkedList.addFirst(new Employee("John","Doe",4567));
        employeeLinkedList.addFirst(new Employee("Mary","Smith",22));
        employeeLinkedList.addFirst(new Employee("Mike","Wilson", 3245));

        Iterator iter = employeeLinkedList.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());

        /*************/
        employeeLinkedList.add(new Employee("Bill","End",987)); //Adds to end
    }
}
