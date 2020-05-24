package com.DataStructureAndAlgorithms.SearchAlgorithms;

import java.util.Arrays;

import static com.DataStructureAndAlgorithms.SortAlgorithms.Main.insertionSort;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[] {20,35,-15,7,55,1,-22};
        insertionSort(intArray); //From package: Sort Algorithms

        System.out.println(Arrays.toString(intArray));
        int numToFind = 55;
        System.out.println("Number to be found: " + numToFind);
        System.out.println("Index: " + binarySearch(intArray,numToFind));
    }

    //Not used
    public static int linearSearch(int[] intArray, int numToFind) {
        for(int index = 0; index < intArray.length; index++)
            if(intArray[index] == numToFind) return index;
        return -1;
    }

    //HAS TO BE SORTED!!!!!!!!!!!!!!!
    public static int binarySearch(int[] intArray, int numToFind) {
        return binarySearch(intArray,numToFind,intArray.length/2,0,intArray.length-1);
    }

    public static int binarySearch(int[] intArray, int numToFind,
                                   int middleIndex, int startIndex, int endIndex) {
        System.out.println(startIndex + ", " + middleIndex + ", " + endIndex);

        if(intArray[middleIndex] == numToFind)
            return middleIndex;
        if(middleIndex == startIndex) //If the all three indices point to the same value and !equal, not in array
            return -1;

        if(intArray[middleIndex] > numToFind) {
            endIndex = middleIndex-1;
            middleIndex = middleIndex/2 + startIndex;
        }
        else {
            startIndex = middleIndex+1;
            middleIndex = (startIndex + endIndex)/2;
        }

        return binarySearch(intArray,numToFind,middleIndex,startIndex,endIndex);
    }
}
