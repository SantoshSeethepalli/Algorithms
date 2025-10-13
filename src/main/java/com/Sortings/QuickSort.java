package com.Sortings;

import java.util.Arrays;

public class QuickSort {

    // https://www.youtube.com/watch?v=Hoixgm4-P4M

    /*
        My Version:

        This algorithm is follows the Divide and Conquer paradigm

        In the arr[left...right]
        1) select the right most element as pivot and then in the remaining sub-array,
        2) we will iterate this sub array and have 2 pointer (i, j)
            - if the current element is greater than the pivot, then we will increment the "j"
            - else increment i and swap (arr[i], arr[j])

        3) so on the (i + 1) is the sorted index of pivot element
        4) recursively we will pass the leftSubArray and rightSubArray to the pivot element (divide step).

        after all the step we will get the sorted array
    */

    /*
    Clean Version:

    This algorithm follows the Divide and Conquer paradigm.

    For the subarray arr[left...right]:
    1. Select the rightmost element as the pivot.
    2. Iterate through the subarray with two pointers (i, j):
       - If the current element is greater than the pivot, increment j.
       - Otherwise, increment i and swap arr[i] with arr[j].
    3. After the iteration, place the pivot at index (i + 1), which is its sorted position.
    4. Recursively apply the same steps to the left and right subarrays relative to the pivot (the divide step).

    After all recursive steps are completed, the array will be fully sorted.
*/


    public int[] quickSort(int[] nums) {

        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }

    private void sort(int[] arr, int left, int right) {

        if(left >= right) return;

        int pivotIdx = partition(arr, left, right);

        sort(arr, left, pivotIdx - 1);
        sort(arr, pivotIdx + 1, right);
    }

    public int partition(int[] arr, int left, int right) {

        int pivot = arr[right];
        int i = left - 1;

        // gather the small from j-pointer and swap it with i-pointer
        for(int j = left; j < right; j++) {
//            uncomment this for sorting in decreasing order
//            if(arr[j] <= pivot) continue;

            if(arr[j] >= pivot) continue;

            i++;
            swap(arr, i, j);
        }

        // place the pivot at the sorted index
        swap(arr, i + 1, right);

        return (i + 1);
    }
}
