package com.Sortings;

public class DualPivot_QuickSort {

    public void dualPivotQuickSort(int[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {

        if(left >= right) return;

        int[] pivots = partition(arr, left, right);

        sort(arr, left, pivots[0] - 1);
        sort(arr,pivots[0] + 1, pivots[1] - 1);
        sort(arr, pivots[1] + 1, right);
    }

    private int[] partition(int[] arr, int left, int right) {

        // To satisfy left pivot <= right pivot
        if(arr[left] > arr[right]) swap(arr, left, right);

        int leftPivot = arr[left];
        int rightPivot = arr[right];

        int lessThanLeftPivotPointer = left + 1;
        int greaterThanRightPivotPointer = right - 1;
        int itr = left + 1;

        // arr[itr] < leftPivot: belongs to left partition
        // arr[itr] > rightPivot: belongs to right partition
        // else: stays in middle partition (itr++)

        while(itr <= greaterThanRightPivotPointer) {

            if(arr[itr] < leftPivot) {

                swap(arr, lessThanLeftPivotPointer++, itr++);
            } else if(arr[itr] > rightPivot) {

                // To make sure the "greaterThanRightPivotPointer" pointer points to a number smaller than the "rightPivot"
                while(greaterThanRightPivotPointer > itr
                        && arr[greaterThanRightPivotPointer] > rightPivot) {

                    greaterThanRightPivotPointer--;
                }
                // we don't increment itr here because it can be lower than the left pivot which will be check in next interation
                swap(arr, greaterThanRightPivotPointer--, itr);
            } else {

                itr++;
            }
        }

        // Remember that these two pointers will point out of bounds for respective sub-array (less than and greater than respective pivots)
        swap(arr, left, lessThanLeftPivotPointer - 1);
        swap(arr, greaterThanRightPivotPointer + 1, right);

        return new int[]{lessThanLeftPivotPointer - 1, greaterThanRightPivotPointer + 1};
    }

    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }
}
