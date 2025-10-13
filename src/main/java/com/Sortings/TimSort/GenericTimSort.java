package com.Sortings.TimSort;

import com.Sortings.BinaryInsertionSort.GenericBinaryInsertionSort;
import com.Sortings.MergeSort.GenericMergeSort;

import java.util.Arrays;

public class GenericTimSort<T extends Comparable<? super T>> {

    private static final int MIN_RUN_SIZE = 4;

    public void sort(T[] arr) {

        new GenericBinaryInsertionSort<T>().helperBinaryInsertionSortMethodForTimSort(arr, 4);

        GenericMergeSort<T> mergeSorter = new GenericMergeSort<>();

        for(int runSize = MIN_RUN_SIZE; runSize < arr.length; runSize *= 2) {
            for(int left = 0; left < arr.length; left += 2 * runSize) {

                int mid = left + runSize - 1;
                int right = Math.min(left + (2 * runSize), arr.length) - 1;

                if(mid <  right) mergeSorter.merge(arr, left, mid, right);
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 10, 13, 14, 51, 89, 71, 54, 13, 1, 5, 89, 3, 25, 24, 65, 90, 11, 41, 66};
        String[] strs = {"Santosh", "Rithwik", "Srikar", "Shek", "Abhi"};

        new GenericTimSort<Integer>().sort(arr);
        new GenericTimSort<String>().sort(strs);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(strs));
    }
}
