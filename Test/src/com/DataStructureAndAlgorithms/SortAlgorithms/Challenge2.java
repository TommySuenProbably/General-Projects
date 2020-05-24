package com.DataStructureAndAlgorithms.SortAlgorithms;

import java.util.Arrays;

//Challenge #2: Implement Insertion Sort with recursion.
public class Challenge2 {
    public static void main(String[] args) {
        int[] intArray = new int[] {20,35,-15,7,55,1,-22};

        System.out.println(Arrays.toString(intArray));
        insertionSort(intArray);
    }

    private static void insertionSort(int[] intArray) {
        insertionSort(intArray,1);
    }

    private static void insertionSort(int[] intArray, int index) {
        if((index == intArray.length) || (intArray.length == 1)) return;

        int temp = intArray[index];
        for(int i = index; i >= 0; i--){
            if(i == 0 || temp >= intArray[i-1]) {
                intArray[i] = temp;
                break;
            }
            intArray[i] = intArray[i-1];
        }

        System.out.println(Arrays.toString(intArray));
        insertionSort(intArray,index+1);
    }
}
