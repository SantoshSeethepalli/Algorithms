package com.Sortings.BinaryInsertionSort;

import java.util.*;

public class GenericBinaryInsertionSort<T extends Comparable<? super T>> {

    public void sort(T[] arr) {
        binaryInsertionSort(arr, 0, arr.length - 1);
    }

    private void binaryInsertionSort(T[] arr, int left, int right) {

        for(int idx = left + 1; idx <= right; idx++) {

            T val = arr[idx];
            int insertionIdx = findLowerBound(arr, left, idx - 1, val);
            moveArrayOneStepForward(arr, insertionIdx, idx - 1);
            arr[insertionIdx] = val;
        }
    }

    public void helperBinaryInsertionSortMethodForTimSort(T[] arr, int MIN_RUN_SIZE) {

        int n = arr.length;

        for(int start = 0; start < n; start += MIN_RUN_SIZE) {

            int end = Math.min(start + MIN_RUN_SIZE - 1, n - 1);
            binaryInsertionSort(arr, start, end);
        }
    }

    private int findLowerBound(T[] arr, int left, int right, T target) {

        if(left > right) return left;
        int mid = (left  + right) / 2;

        if(arr[mid].compareTo(target) >= 0) {

            return findLowerBound(arr, left, mid - 1, target);
        } else {

            return findLowerBound(arr, mid + 1, right, target);
        }
    }

    private void moveArrayOneStepForward(T[] arr, int leftEnd, int rightEnd) {

        for(int idx = rightEnd; idx >= leftEnd; idx--) {

            arr[idx + 1] = arr[idx];
        }
    }


    // methods for sorting List<T>:

    public void sort(List<T> arr) {
        binaryInsertionSort(arr, 0, arr.size() - 1);
    }

    private void binaryInsertionSort(List<T> arr, int left, int right) {

        for(int idx = left + 1; idx <= right; idx++) {

            T val = arr.get(idx);
            int insertionIdx = findLowerBound(arr, left, idx - 1, val);
            moveArrayOneStepForward(arr, insertionIdx, idx - 1);
            arr.set(insertionIdx, val);
        }
    }

    private int findLowerBound(List<T> arr, int left, int right, T target) {

        if(left > right) return left;
        int mid = (left  + right) / 2;

        if(arr.get(mid).compareTo(target) >= 0) {

            return findLowerBound(arr, left, mid - 1, target);
        } else {

            return findLowerBound(arr, mid + 1, right, target);
        }
    }

    private void moveArrayOneStepForward(List<T> arr, int leftEnd, int rightEnd) {

        for(int idx = rightEnd; idx >= leftEnd; idx--) {

            arr.set(idx + 1, arr.get(idx));
        }
    }
}
