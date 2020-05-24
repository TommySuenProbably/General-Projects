package com.DataStructureAndAlgorithms.Lists;

import com.DataStructureAndAlgorithms.Employee;

public class DoublyLinkedLists {
    public static void main(String[] args) {
        EmployeeLinkedLists employeeLinkedList = new EmployeeLinkedLists();

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        employeeLinkedList.addToHead(janeJones);
        employeeLinkedList.addToHead(johnDoe);
        employeeLinkedList.addToHead(marySmith);
        employeeLinkedList.addToHead(mikeWilson);
        employeeLinkedList.printList();

        employeeLinkedList.removeFromHead();
        System.out.println(employeeLinkedList.getSize());
        employeeLinkedList.printList();

        Employee tommySuen =  new Employee("Tommy","Suen",98);
        employeeLinkedList.addToHead(tommySuen);
        employeeLinkedList.printList();
    }

    static class EmployeeNode {
        private EmployeeNode previous;
        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode(EmployeeNode previous, Employee employee, EmployeeNode next) {
            this.previous = previous;
            this.employee = employee;
            this.next = next;
        }

        public EmployeeNode getPrevious() {
            return previous;
        }

        public void setPrevious(EmployeeNode previous) {
            this.previous = previous;
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

        @Override
        public String toString() {
            return "EmployeeNode{" +
                    "previous=" + previous +
                    ", employee=" + employee +
                    ", next=" + next +
                    '}';
        }
    }

    static class EmployeeLinkedLists {
        private EmployeeNode head;
        private EmployeeNode tail;
        private int size = 0;

        public EmployeeLinkedLists() {
        }

        public void addToHead(Employee employee) {
            size++;

            EmployeeNode node = new EmployeeNode(employee);
            node.setNext(head);
            head = node;
        }

        public void addToTail(Employee employee) {
            size++;

            EmployeeNode node = new EmployeeNode(employee);
            node.setPrevious(tail);
            tail = node;
        }

        public EmployeeNode removeFromHead() {
            size--;

            EmployeeNode removedNode = head;
            head.getNext().setPrevious(null);
            head = head.getNext();

            removedNode.setNext(null);
            return removedNode;
        }

        public EmployeeNode removeFromTail() {
            size--;

            EmployeeNode removedNode = head;
            head.getPrevious().setNext(null);
            head = head.getPrevious();

            removedNode.setPrevious(null);
            return removedNode;
        }

        public EmployeeNode getHead() {
            return head;
        }

        public void setHead(EmployeeNode head) {
            this.head = head;
        }

        public EmployeeNode getTail() {
            return tail;
        }

        public void setTail(EmployeeNode tail) {
            this.tail = tail;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void printList(){
            EmployeeNode current = head;
            System.out.print("Null <-> ");

            while(current != null){
                System.out.print(current.getEmployee().getFirstName() + " " +
                        current.getEmployee().getLastName() + " " +
                        "<-> ");
                current = current.getNext();
            }
            System.out.println("Null");
        }
    }
}
