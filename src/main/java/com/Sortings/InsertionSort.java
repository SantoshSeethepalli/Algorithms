package com.Sortings;

import java.util.Arrays;

public class InsertionSort {

    // https://www.youtube.com/watch?v=JU767SDMDvA

    /*
        While looping from left to right,
        we compare the current element with the elements to its left and find the correct index where it should be placed so that the left subarray remains sorted.
        By "inserting" the element at its correct position, we gradually sort the entire array.
    */

    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }

    public int[] insertionSort(int[] nums) {

        for(int firstElementInUnSortedListIdx = 1; firstElementInUnSortedListIdx < nums.length; firstElementInUnSortedListIdx++) {

            for(int currentElementIdx = firstElementInUnSortedListIdx; currentElementIdx > 0; currentElementIdx--) {

                if(nums[currentElementIdx] > nums[currentElementIdx - 1]) break;

                swap(nums, currentElementIdx, currentElementIdx - 1);
            }
        }

        return nums;
    }
}
