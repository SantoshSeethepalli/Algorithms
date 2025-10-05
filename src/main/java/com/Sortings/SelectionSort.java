package com.Sortings;

public class SelectionSort {

    // https://www.youtube.com/watch?v=g-PGLbMth_g


    /*
        While looping from left -> right,
        for each position, find the index of the minimum element in the unsorted portion (to the right of the current element),
        then swap the current element with that minimum element.
     */

    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }

    public int[] selectionSort(int[] nums) {

        for(int firstIdx = 0; firstIdx < nums.length - 1; firstIdx++) {

            int minIdx = firstIdx;

            for(int secondIdx = firstIdx + 1; secondIdx < nums.length; secondIdx++) {

                if(nums[secondIdx] < nums[minIdx]) {

                    minIdx = secondIdx;
                }
            }

            if(minIdx != firstIdx) {

                swap(nums, firstIdx, minIdx);
            }
        }

        return nums;
    }
}
