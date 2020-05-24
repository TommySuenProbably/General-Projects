/*
Hashmaps are not synchronized and accept null values and null keys
Hash-tables are synchronized.
 */

package com.DataStructureAndAlgorithms.Hashtables;

import com.DataStructureAndAlgorithms.Employee;
import com.DataStructureAndAlgorithms.Hashtables.ChainedHashtable;
import com.DataStructureAndAlgorithms.Hashtables.SimpleHashtable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        hashMap();
    }

    public static void hashMap() {
        Hashtable<String,Employee> hashmap = new Hashtable<>();

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        hashmap.put("Jones",janeJones);
        hashmap.put("Doe",johnDoe);
        hashmap.put("Smith",marySmith);
        hashmap.put("Wilson",mikeWilson);

        //removeEldestEntry() -> for caches, you may want to remove the oldest entry to give space
        //getOrDefault(key,value) vs get() -> if you were to get null, you can specify value to be returned instead
        //putIfAbsent() vs put() -> one replaces the existing value while the other does not
//        Iterator<Employee> iterator =  hashmap.values().iterator();
//        while(iterator.hasNext())
//                System.out.println(iterator.next());
        hashmap.forEach((k,v) -> System.out.println("Key: " + k + ", Employee: " + v));
    }

    public static void arrayHashtable() {
        SimpleHashtable hashtable = new SimpleHashtable();

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        hashtable.put("Jones",janeJones);
        hashtable.put("Doe",johnDoe);
        hashtable.put("Smith",marySmith);
        hashtable.put("Wilson",mikeWilson);

        hashtable.printHashtable();
        System.out.println("Retrieve Key 'Smith': " + hashtable.get("Smith"));

        hashtable.remove("Smith");
        hashtable.printHashtable();
    }

    public static void chainedHashtable() {
        ChainedHashtable hashtable = new ChainedHashtable();

        Employee janeJones = new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee marySmith = new Employee("Mary","Smith",22);
        Employee mikeWilson = new Employee("Mike","Wilson", 3245);

        hashtable.put("Jones",janeJones);
        hashtable.put("Doe",johnDoe);
        hashtable.put("Smith",marySmith);
        hashtable.put("Wilson",mikeWilson);

        hashtable.printHashtable();
        System.out.println("Retrieve Key 'Smith': " + hashtable.get("Smith"));

        hashtable.remove("Smith");
        hashtable.printHashtable();
    }
}
