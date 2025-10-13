package com.Sortings.TimSort;

import com.Sortings.BinaryInsertionSort.PrimitiveBinaryInsertionSort;
import com.Sortings.MergeSort.PrimitiveMergeSort;

import java.util.Arrays;

public class PrimitiveTimSort {

    private static final int MIN_RUN_SIZE = 4;

    public void sort(int[] arr) {

        new PrimitiveBinaryInsertionSort().helperBinaryInsertionSortMethodForTimSort(arr, MIN_RUN_SIZE);

        for(int runSize = MIN_RUN_SIZE; runSize < arr.length; runSize *= 2) {

            for(int left = 0; left < arr.length; left += 2 * runSize) {

                int mid = left + runSize - 1;
                int right = Math.min(left + (2 * runSize) - 1, arr.length - 1);

                if(mid <  right) new PrimitiveMergeSort().merge(arr, left, mid, right);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 25, 4, 5, 11, 1, 2, 6, 12, 78, 23, 43, 1, 23, 89, 10};

        new PrimitiveTimSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
