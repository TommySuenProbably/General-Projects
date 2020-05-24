/*
A common strategy to handle hashtable collisions is called open addressing. If the spot is occupied, then,
another spot is found. Method used is called Linear Probing.
 */

package com.DataStructureAndAlgorithms.Hashtables;

import com.DataStructureAndAlgorithms.Employee;
import com.DataStructureAndAlgorithms.StoredEmployee;

import java.util.Arrays;

public class SimpleHashtable {
    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)) {
            int stopIndex = hashedKey;

            //hashedKey = ++hashedKey % hashtable.length;
            // The reason that the first probe must be handled is that the stopIndex = hashedKey
            if(hashedKey == hashtable.length-1)
                hashedKey = 0;
            else
                hashedKey++;

            while(hashedKey != stopIndex && occupied(hashedKey))
                hashedKey = ++hashedKey % hashtable.length;
        }

        if (occupied(hashedKey))
            System.out.println("All filled to the brim.");
        else
            hashtable[hashedKey] = new StoredEmployee(key,employee);
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if(hashedKey == -1)
            return null;
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if(hashedKey == -1)
            return null;

        Employee removedEmployee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;
        rehash();
        return removedEmployee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if(occupied(hashedKey) && hashtable[hashedKey].key.equals(key))
            return hashedKey;

        int stopIndex = hashedKey;

        //hashedKey = ++hashedKey % hashtable.length;
        // The reason that the first probe must be handled is that the stopIndex = hashedKey
        if(hashedKey == hashtable.length-1)
            hashedKey = 0;
        else
            hashedKey++;

        while(hashedKey != stopIndex &&
                occupied(hashedKey) &&
                !hashtable[hashedKey].key.equals(key))
            hashedKey = ++hashedKey % hashtable.length;

        if (occupied(hashedKey) && hashtable[hashedKey].key.equals(key))
            return hashedKey;

        System.out.println("This employee is not in the table.");
        return -1;
    }

    private void rehash() {
        StoredEmployee[] newArray = Arrays.copyOf(hashtable,hashtable.length);
        hashtable = new StoredEmployee[hashtable.length];

        for(StoredEmployee employee: newArray)
            if(employee != null)
                put(employee.key, employee.employee);

    }

    private boolean occupied(int position) {
        return (hashtable[position] != null);
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        for(int index = 0; index < hashtable.length; index++) {
            if (hashtable[index] == null)
                System.out.println("Empty");
            else
                System.out.println(hashtable[index].employee);
        }
    }
}
