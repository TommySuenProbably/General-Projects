package com.DataStructureAndAlgorithms.Lists;

import com.DataStructureAndAlgorithms.Employee;

public class SinglyLinkedLists {
    static class EmployeeNode {
        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee){
            this.employee = employee;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode getNext() {
            return next;
        }

        public void setNext(EmployeeNode next) {
            this.next = next;
        }

        public String toString(){
            return employee.toString();
        }
    }

    static class EmployeeLinkedList {
        private SinglyLinkedLists.EmployeeNode head;
        private int size = 0;

        public EmployeeLinkedList(){
        }

        public EmployeeLinkedList(Employee employee){
            addToFront(employee);
        }

        public EmployeeLinkedList(SinglyLinkedLists.EmployeeNode head){
            this.head = head;
        }

        public SinglyLinkedLists.EmployeeNode getHead() {
            return head;
        }

        public void setHead(SinglyLinkedLists.EmployeeNode head) {
            this.head = head;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void addToFront(Employee employee){
            SinglyLinkedLists.EmployeeNode node = new SinglyLinkedLists.EmployeeNode(employee);
            node.setNext(head);
            head = node; //Set the pointer to newly inserted node
            size++;
        }

        public SinglyLinkedLists.EmployeeNode removeFromFront() {
            if(isEmpty()) return null;

            SinglyLinkedLists.EmployeeNode removedNode = head;
            head = removedNode.getNext();
            size--;
            removedNode.setNext(null); //This is just more of  a precaution
            return removedNode;
        }

        public boolean isEmpty() {
            return (head == null);
        }

        public void printList(){
            SinglyLinkedLists.EmployeeNode current = head;
            System.out.print("Head -> ");

            while(current != null){
                System.out.print(current.getEmployee().getFirstName() + " " +
                        current.getEmployee().getLastName() + " " +
                        "-> ");
                current = current.getNext();
            }
            System.out.println("Null");
        }
    }

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        EmployeeLinkedList employeeLinkedList = new EmployeeLinkedList();
        employeeLinkedList.addToFront(janeJones);
        employeeLinkedList.addToFront(johnDoe);
        employeeLinkedList.addToFront(marySmith);
        employeeLinkedList.addToFront(mikeWilson);

        System.out.println(employeeLinkedList.isEmpty());
        System.out.println(employeeLinkedList.getSize());
        employeeLinkedList.printList();

        employeeLinkedList.removeFromFront();
        System.out.println(employeeLinkedList.getSize());
        employeeLinkedList.printList();
    }
}
