package com.DataStructureAndAlgorithms.SortAlgorithms;

import java.util.Arrays;

//Challenge #3: Sort the strings using radix sort
public class Challenge3 {
    public static void main(String[] args) {
        String[] grams = new String[] {"bcdef","dbaqc","abcde","omadd","bbbbb"};

        radixSort(grams,26,5);
    }

    private static void radixSort(String[] stringArray, int radix, int width) {
        int[] countingArray = new int[radix];
        String[] temp = new String[stringArray.length];

        for(int position = width-1; position >= 0; position--) {
            for(int index = 0; index < countingArray.length; index++)
                countingArray[index] = 0;

            for (String value : stringArray)
                countingArray[value.charAt(position) - 'a']++;
            for (int index = 1; index < countingArray.length; index++)
                countingArray[index] += countingArray[index - 1];

            for(int index = stringArray.length-1; index >= 0; index--)
                temp[--countingArray[stringArray[index].charAt(position) - 'a']] = stringArray[index];

            stringArray = Arrays.copyOf(temp, temp.length);
            System.out.println(Arrays.toString(stringArray));
        }
    }
}
