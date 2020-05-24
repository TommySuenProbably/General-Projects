/*
Arrays are one contiguous structure (I know already but just as a note)
Time Complexity vs Memory Complexity
Int is 4 bytes
 */

package com.DataStructureAndAlgorithms.SortAlgorithms;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] intArray = new int[] {20,35,-15,7,55,1,-22};

        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(intArray));

	    //bubbleSort(intArray);
        //selectionSort(intArray);
        //insertionSort(intArray);
        //shellSort(intArray);
        //mergeSort(intArray);
        //quickSort(intArray);
        //countingSort(new int[] {2,5,9,8,2,8,7,10,4,3});
        radixSort(new int[] {4725,4586,1330,8792,1594,5729},10,4);
        //Arrays.parallelSort(intArray); System.out.println(Arrays.toString(intArray));

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration);
    }

    static void swap(int[] intArray, int i, int j){
        if(i == j) return;

        int temp = intArray[j];
        intArray[j] = intArray[i];
        intArray[i] = temp;
    }

    /*
    Name: Bubble Sort
    Description: Bubble sort compares pairs of elements at a time and swaps as needed.
    It moves like a CONVEYOR BELT.
    Origin: The largest numbers bubble up to the top of the array.
    Time Complexity: O(n^2)
    Stability: Stable Sort
     */
    static void bubbleSort(int[] intArray){
        for(int i1 = (intArray.length-1); i1 > 0; i1--){
            boolean sorted = true; //Early exit condition

            for(byte i2 = 0; i2 < i1; i2++){
                if(intArray[i2] > intArray[i2+1]) {
                    swap(intArray, i2, i2+1);
                    sorted = false;
                }
            }

            System.out.println(Arrays.toString(intArray));
            if(sorted) break;
        }
    }

    /*
    Name: Selection Sort
    Description: It finds the largest element of each unsorted partition. It moves that to the element to the
    front and shortens the partition by one until it has passed through.
    Origin: It selects each element one by one. Its complexity is always quadratic.
    Time Complexity: O(n^2)
    Stability: Unstable Sort
     */
    static void selectionSort(int[] intArray) {
        for(int unsortedPartition = intArray.length-1; unsortedPartition > 0; unsortedPartition--) {
            int i = 0;

            for(int count = 1; count <= unsortedPartition; count++)
                if(intArray[count] > intArray[i]) i = count;

            else swap(intArray, i, unsortedPartition);
            System.out.println(Arrays.toString(intArray));
        }
    }

    /*
    Name: Insertion Sort
    Description: It grows the sorted partition by one and inserts each element until completion.
    Origin: It inserts element by element.
    Time Complexity: O(n^2)
    Stability: Stable Sort
     */
    //LESSON LEARNED: Don't use breaks
    public static void insertionSort(int[] intArray) {
        for(int index = 1; index < intArray.length; index++) {
            int temp = intArray[index];

            int count;
            for(count = index; (count > 0) && (intArray[count-1] > temp); count--)
                intArray[count] = intArray[count-1];
            intArray[count] = temp;

            System.out.println(Arrays.toString(intArray));
        }
    }

    /*
    Name: Shell Sort
    Description: This is a modified insertion sort. Each iteration compares not adjacent elements but elements
    a certain gap away. It is like a wide sort, with each iteration have smaller gaps (simply length/2 [truncated]
    ). The gap can also use the Knuth Sequence, (3^k-1)/2. The final step is basically insertion sort, but this
    can be combined with Bubble Sort.
    Origin: Named after computer scientist, Donald Shell.
    Time Complexity: O(n^2)
    Stability: Unstable Sort <-- The wider iterations allow the twin to bypass
    */
    static void shellSort(int[] intArray) {
        shellSort(intArray, intArray.length/2);
    }

    private static void shellSort(int[] intArray, int gap) {
        for(int index = gap; index < intArray.length; index+= gap) {
            int temp = intArray[index];

            int count;
            for(count = index; (count > 0) && (intArray[count-gap] > temp); count-= gap)
                intArray[count] = intArray[count-gap];
            intArray[count] = temp;

            System.out.println(Arrays.toString(intArray));
        }
        if(gap == 1) return;
        shellSort(intArray, gap/2);
    }

    /*
    Name: Merge Sort
    Description: **I used many temporary arrays (bad), Sarah only tracked the indices. Hers is faster...**
    Merge Sort splits the array into halves and begins sorting when those halves reach a length of '1'. The
    merging uses a few optimizations to copy elements into the correct order. The splitting or "Divide and
    Conquer" nature of this algorithm uses recursion.
    Origin: It splits the array into sub-arrays and sorts upon merging "sibling arrays".
    Time Complexity: O(nlogn)
    Stability: Stable Sort
    */
    static void mergeSort(int[] intArray) {
        if(intArray.length == 1 || intArray == null) return;

        //SPLITTING PHASE
        int[] left = new int[intArray.length/2];
        int[] right = new int[intArray.length - intArray.length/2];
        for(int index = 0; index < intArray.length; index++){
            if(index < left.length)
                left[index] = intArray[index];
            else
                right[index - left.length] = intArray[index];
        }

        mergeSort(left); mergeSort(right); //Recursive call

        //MERGING PHASE
        int i = 0, j = 0, intArrayIndex = 0;

        while(intArrayIndex < intArray.length)
            intArray[intArrayIndex++] =
                ((i != left.length) && ((j == right.length) || (left[i] <= right[j]))) ? left[i++] : right[j++];
        System.out.println(Arrays.toString(intArray));
    }
    /* Better Execution of Merge Sort
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }
     */

    /*
    Name: Quick Sort
    Description: This variation uses the first element as the pivot. The pivot is chosen. A bigger element is
    found start from the right. Then, a smaller element is found from the left. It alternates until (i < j), where
    the search ends, as all terms have been grouped into smaller or bigger than pivot. Quicksort is repeated for
    the left and right subarrays of these smaller and bigger elements. This is recursive because it divides the
    problem into smaller and smaller unsorted arrays.
    Origin: Because it's quick!!!
    Time Complexity: O(nlogn) <-- But famously better than Merge Sort
    Stability: Unstable Sort
    */
    static void quickSort(int[] intArray) {
        quickSort(intArray, 0, intArray.length);
    }

    private static void quickSort(int[] intArray, int start, int end) {
        if(end-start < 2 || intArray == null) return;

        int i = start, j = end, pivot = intArray[i], pivotLocation = i;

        while (i < j) {
            while (i < j && intArray[--j] >= pivot);
            if (i < j)
                intArray[i] = intArray[j];

            while (i < j && intArray[++i] <= pivot);
            if (i < j)
                intArray[j] = intArray[i];
        }
        pivotLocation = j;
        intArray[pivotLocation] = pivot;
        System.out.println(Arrays.toString(intArray));

        quickSort(intArray,start,pivotLocation); quickSort(intArray,pivotLocation+1,end);
    }

    /* This is a counting array for values 1-10
    Name: Counting Sort
    Description: Instead of comparing elements to one another, this sort counts the occurrence of each element
    and fills the original with this information. This algorithm only runs in linear time if the amount of
    elements is about or greater the length of the range. To create a stable sort, a linked list must be
    implemented.
    Origin: It counts the occurrence of each term.
    Time Complexity: O(n)
    Stability: Unstable Sort / STABLE through Linked List
    */
    static void countingSort(int[] intArray) {
        final int MIN = 0, MAX = 10;
        int[] countingArray = new int[MAX-MIN];

        for(int i = 0; i < intArray.length; i++)
            countingArray[intArray[i]-1]++;

        int k = 0;
        for(int i = 0; i < countingArray.length; i++)
            for(int j = 0; j < countingArray[i]; j++)
                intArray[k++] = i+1;
        System.out.println(Arrays.toString(intArray));
    }

    /*
    Name: Radix Sort
    Description: Radix refers to the amount of different digits (e.g. decimal -> 10, binary -> 2, alphabet -> 26).
    This algorithm sorts first by the least significant digit to the most, with each iteration a stable sort.
    Stability is important to preserve the ordering. Why does it work? I don't know; you can't go the other
    way because you cannot compare smaller weights. I don't know, magic?
    Origin: The sort uses an assumption on the "radix".
    Time Complexity: O(n) [but overhead for separation of digits]
    Stability: Stable Sort
    */
    static void radixSort(int[] intArray, int radix, int width) {
        int[] temp = new int[intArray.length]; //For Sorting Phase Use
        int[] countingArray = new int[radix];

        for(int position = 0; position < width; position++) {
            //Modified Counting Array Creation
            for (int i = 0; i < countingArray.length; i++) //Reset Counting Array
                countingArray[i] = 0;

            for (int value: intArray)
                countingArray[getDigit(value, radix, position)]++;
            for (int i = 1; i < countingArray.length; i++)
                countingArray[i] += countingArray[i-1];

            //Stable Counting Sort based off Position
            for(int i = intArray.length-1; i >= 0; i--)
                temp[--countingArray[getDigit(intArray[i], radix, position)]] = intArray[i];

            intArray = Arrays.copyOf(temp, temp.length);
            System.out.println(Arrays.toString(intArray));
        }
    }

    private static int getDigit(int num, int radix, int position) {
        return num / (int) Math.pow(10,position) % radix;
    }
}
