package com.Sortings.MergeSort;

import java.util.*;

public class GenericMergeSort<T extends Comparable<? super T>> {
    public void sort(T[] arr) {

        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(T[] arr, int left, int right) {

        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public void merge(T[] arr, int left, int mid, int right) {

        T[] leftSubArray = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightSubArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0;
        int j = 0;
        int originalIdx = left;

        while(i < leftSubArray.length && j  < rightSubArray.length) {

            if(leftSubArray[i].compareTo(rightSubArray[j]) < 0) { // leftSubArray element is less than rightSubArray element

                arr[originalIdx++] = leftSubArray[i++];
            } else {

                arr[originalIdx++] = rightSubArray[j++];
            }
        }

        while(i < leftSubArray.length) arr[originalIdx++] = leftSubArray[i++];

        while(j < rightSubArray.length) arr[originalIdx++] = rightSubArray[j++];

    }
}
