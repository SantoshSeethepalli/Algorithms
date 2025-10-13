package com.Sortings;

import java.util.Arrays;
import java.util.Queue;

public class IntroSort {

    HeapSort heapSort;
    InsertionSort insertionSort;
    QuickSort quickSort;

    public IntroSort() {

        this.heapSort = new HeapSort();
        this.insertionSort = new InsertionSort();
        this.quickSort = new QuickSort();
    }

    private void selectAndSort(int start, int end, int[] arr, int depthLimit) {

        if(end - start < 16) {

            insertionSort.insertionSort(arr);
        } else {

            if(depthLimit == 0) {

                heapSort.sort(arr);
                return;
            }

            depthLimit--;
            int pivot = findPivot(start, (start + end) / 2, end, arr);
            swap(arr, pivot, end);

            int p = quickSort.partition(arr, start, end);

            selectAndSort(start, p - 1, arr, depthLimit);
            selectAndSort(p + 1, end, arr, depthLimit);
        }
    }

    public void sort(int[] arr) {

        int depthLimit = (int) (2 * Math.floor(
                Math.log(arr.length) / Math.log(2) // convert log base 10 to log base 2
        ));

        selectAndSort(0, arr.length - 1, arr, depthLimit);
    }

    private int findPivot(int start, int mid, int end, int[] arr) {

        int max = Math.max(arr[start], Math.max(arr[mid], arr[end]));
        int min = Math.min(arr[start], Math.min(arr[mid], arr[end]));

        int median = 0;

        if(max == arr[start]) {

            if(min == arr[end]) median = arr[mid];
            else median = arr[end];
        } else if(max == arr[mid]) {

            if(min == arr[end]) median = arr[start];
            else median = arr[mid];
        } else {

            if(min == arr[start]) median = arr[mid];
            else median = arr[start];
        }

        if(median == arr[start]) return start;
        else if(median == arr[mid]) return  mid;
        else return end;
    }

    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{837, 12, 455, 98, 671, 234, 789, 56, 902, 314, 421, 76, 653, 289, 512, 47, 871, 138, 390, 607, 245, 764, 18, 569, 83, 341, 695, 27, 480, 903, 156, 638, 274, 791, 49, 365, 128, 832, 59, 471, 314, 907, 205, 678, 142, 556, 39, 720, 81, 492, 614, 33, 788, 290, 157, 649, 44, 375, 813, 98, 512, 226, 701, 364, 29, 867, 131, 582, 47, 433, 673, 205, 798, 12, 567, 398, 254, 722, 61, 489, 314, 781, 88, 512, 301, 694, 19, 467, 805, 120, 530, 357, 41, 672, 234, 790, 15, 568, 402, 277, 811, 49, 623, 289, 905, 33, 478, 716, 87, 541, 362, 29, 674, 243, 783, 59, 499};
        new IntroSort().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
