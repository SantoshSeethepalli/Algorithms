package com.Sortings;

import java.util.Arrays;

public class ThreeWayQuickSort {

    public void sort(int[] arr) {

        threeWayQuickSort(arr, 0, arr.length - 1);
    }

    private void threeWayQuickSort(int[] arr, int left, int right) {

        if (left >= right) return;

        int pivotElement = arr[right];
        int lessThanPivotIdx = left;
        int greaterThanPivotIdx = right;
        int itr = left;

        while (itr <= greaterThanPivotIdx) {

            if (arr[itr] == pivotElement) {

                itr++;
            } else if (arr[itr] < pivotElement) {

                swap(arr, itr++, lessThanPivotIdx++);
            } else {

                swap(arr, itr, greaterThanPivotIdx--);
            }
        }

        threeWayQuickSort(arr, left, lessThanPivotIdx - 1);
        threeWayQuickSort(arr, greaterThanPivotIdx + 1, right);
    }

    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }
}
