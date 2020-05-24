package com.DataStructureAndAlgorithms.Hashtables;

import com.DataStructureAndAlgorithms.Employee;
import com.DataStructureAndAlgorithms.StoredEmployee;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[10];
        for(int i = 0; i < hashtable.length; i++)
            hashtable[i] = new LinkedList<>();
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);

        hashtable[hashedKey].add(new StoredEmployee(key,employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iter = hashtable[hashedKey].listIterator();
        StoredEmployee getEmployee = null;
        while(iter.hasNext()) {
             getEmployee = iter.next();
            if (getEmployee.key.equals(key)) return getEmployee.employee;
        }
        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);

        //VERY SIMILAR code to get(), however, we cannot use get because it returns an object of type <Employee>
        ListIterator<StoredEmployee> iter = hashtable[hashedKey].listIterator();
        StoredEmployee removedEmployee = null;
        int index = -1;

        while(iter.hasNext()) {
            index++;
            removedEmployee = iter.next();
            if (removedEmployee.key.equals(key)) break;
        }

        if(removedEmployee == null)
            return null;
        hashtable[hashedKey].remove(index);
        return removedEmployee.employee;
    }

    private int hashKey(String key) {
        //return key.length() % hashtable.length;

        //Hash-coding can provide negative values. String has a built-in hash function, which is usually
        //overridden. The mod by the table length ensures the value fits in the table.
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashtable() {
        for(int i  = 0; i < hashtable.length; i++) {
            System.out.print("Position " + i + ": ");

            if(hashtable[i].isEmpty())
                System.out.println("Empty");
            else {
                ListIterator<StoredEmployee> iter = hashtable[i].listIterator();

                while(iter.hasNext())
                    System.out.print(iter.next().employee + " -> ");
                System.out.println("Null");
            }
        }
    }
}
