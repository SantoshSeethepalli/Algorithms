package com.Sortings;

public class BubbleSort {

    // https://youtu.be/xli_FI7CuzA?si=KCUrhfRoKx5MH0wO

    /*
        We loop approximately O(n^2) times —
        each outer iteration runs one fewer comparison than the previous.

        In the inner loop (left to right), compare adjacent elements and swap them if the current element is greater than the next one,
        effectively "bubbling" the larger element forward.
    */


    private void swap(int[] arr, int firstIdx, int secondIdx) {

        int temporaryVariable = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temporaryVariable;
    }

    public int[] bubbleSort(int[] nums) {

        for(int end = nums.length - 1; end >= 0; end--) {
            for(int start = 0; start < end; start++) {

              if(nums[start] > nums[start + 1]) {

                  swap(nums, start, start + 1);
              }
            }
        }

        return nums;
    }
}