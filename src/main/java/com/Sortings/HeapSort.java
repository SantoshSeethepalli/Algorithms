package com.Sortings;

import java.util.Arrays;

public class HeapSort {

    // The current code implement's the heap sort and sorts the code in ascending order.
    // If wanted to sort in descending order, use minHeapify method in-place of maxHeapify method in "heapSort" method

    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }

    private void minHeapify(int[] arr, int heapSize, int parentIdx) {

        int actualParentIdx = parentIdx;

        int leftChildIdx = 2 * parentIdx;
        int rightChildIdx = 2 * parentIdx + 1;

        if(leftChildIdx < heapSize && arr[actualParentIdx] > arr[leftChildIdx]) {

            actualParentIdx = leftChildIdx;
        }

        if(rightChildIdx < heapSize && arr[actualParentIdx] > arr[rightChildIdx]) {

            actualParentIdx = rightChildIdx;
        }

        if(actualParentIdx != parentIdx) {

            swap(arr, actualParentIdx, parentIdx);

            // Recursively call the heapify function
            minHeapify(arr, heapSize, actualParentIdx);
        }
    }

    private void maxHeapify(int[] arr, int heapSize, int parentIdx) {

        int actualParentIdx = parentIdx;

        int leftChildIdx = 2 * parentIdx;
        int rightChildIdx = 2 * parentIdx + 1;

        if(leftChildIdx < heapSize && arr[actualParentIdx] < arr[leftChildIdx]) {

            actualParentIdx = leftChildIdx;
        }

        if(rightChildIdx < heapSize && arr[actualParentIdx] < arr[rightChildIdx]) {

            actualParentIdx = rightChildIdx;
        }

        if(actualParentIdx != parentIdx) {

            swap(arr, actualParentIdx, parentIdx);

            // Recursively call the heapify function
            maxHeapify(arr, heapSize, actualParentIdx);
        }
    }

    private void heapSort(int[] arr)  {

        int n = arr.length;

        // call heapify on non-leaf node's from the end
        for(int idx = n / 2 - 1; idx >= 0; idx--) {

            maxHeapify(arr, n, idx);
        }

        for(int idx = n - 1; idx > 0; idx--) {

            // Swap the largest element in the Heap (
            swap(arr, 0, idx);

            maxHeapify(arr, idx, 0);
        }
    }
}
