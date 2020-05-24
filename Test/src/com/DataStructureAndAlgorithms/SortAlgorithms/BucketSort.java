//This is separated from the other sort algorithms because it built with a hashtable

package com.DataStructureAndAlgorithms.SortAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] intArray = new int[] {54,46,83,66,95,92,43};

        bucketSort(intArray);
    }

    private static void bucketSort(int[] intArray) {
        List<Integer>[] buckets = new List[10];

        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<Integer>();
    }



//    private int hashKey(int digit) {
//        return digit % buckets.length;
//    }

}
