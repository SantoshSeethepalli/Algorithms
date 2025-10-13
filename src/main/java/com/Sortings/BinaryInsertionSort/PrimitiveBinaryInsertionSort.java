package com.Sortings.BinaryInsertionSort;

public class PrimitiveBinaryInsertionSort {

    public void sort(int[] arr) {


        binaryInsertionSort(arr, 0, arr.length - 1);
    }

    public void helperBinaryInsertionSortMethodForTimSort(int[] arr, int MIN_RUN_SIZE) {

        int n = arr.length;
        int numberOfChunks = Math.ceilDiv(n, MIN_RUN_SIZE);

        for(int start = 0; start < n; start += MIN_RUN_SIZE) {

            int end = Math.min(start + MIN_RUN_SIZE - 1, n - 1);
            binaryInsertionSort(arr, start, end);
        }
    }

    private void binaryInsertionSort(int[] arr, int left, int right) {

        for(int idx = left + 1; idx <= right; idx++) {

            int val = arr[idx];

            // Here we are doing +1 because we are finding lower bound
            int insertionIdx = findLowerBound(arr, left, idx - 1, val);

            moveArrayOneStepForward(arr, insertionIdx, idx - 1);

            arr[insertionIdx] = val;
        }
    }

    private int findLowerBound(int[] arr, int left, int right, int target) {

        if(left > right) {
            return left;
        }

        int mid = (left + right) / 2;

        if(arr[mid] >= target) {

            return findLowerBound(arr, left, mid - 1, target);
        } else {

            return findLowerBound(arr, mid + 1, right, target);
        }
    }

    public void moveArrayOneStepForward(int[] arr, int left, int right) {

        for(int idx = right; idx >= left; idx--) {

            arr[idx + 1] = arr[idx];
        }
    }
}
