package com.DataStructureAndAlgorithms.SortAlgorithms;

import java.util.Arrays;

//Challenge #1: Implement merge sort but backwards
public class Challenge1 {
    public static void main(String[] args){
        int[] intArray = new int[] {20,35,-15,7,55,1,-22};
        System.out.println(Arrays.toString(intArray));

        mergeSort(intArray,0,intArray.length);
    }

    private static void mergeSort(int[] intArray, int min, int max){
        if(max-min < 2) return;

        //Splitting Phase
        int mid = (max+min)/2;
        mergeSort(intArray,min,mid); mergeSort(intArray,mid,max);

        //Merging Phase
        if(intArray[mid-1] >= intArray[mid]) return;

        int i = min, j = mid, tempIndex = 0;
        int[] temp = new int[max-min];
        while(i < mid && j < max)
            temp[tempIndex++] = intArray[i] >= intArray[j] ? intArray[i++] : intArray[j++];

        System.arraycopy(intArray, i, intArray, min + tempIndex, mid - i);
        System.arraycopy(temp, 0, intArray, min, tempIndex);
        System.out.println(Arrays.toString(intArray));
    }
}
