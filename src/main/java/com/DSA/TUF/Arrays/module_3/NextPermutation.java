package com.DSA.TUF.Arrays.module_3;

public class NextPermutation {

    private void swap(int[] nums, int i, int j) {

        if(i >= nums.length || i < 0 ||
                j >= nums.length || j < 0 ) {
            return;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {

        if(start > end) return;

        while(start < end) {

            swap(nums, start, end);

            start++;
            end--;
        }
    }

    private int findIndexWhereArrayStartsDecreasing(int[] arr) {


        for(int i = arr.length - 2; i >= 0; i--) {

            if(arr[i] < arr[i + 1]) return i;
        }

        return -1;
    }

    private int findFirstGreaterThanPivotElementFromTheEnd(int[] arr, int idx) {

        int resIdx = arr.length - 1;
        for(int i = arr.length - 1; i > idx; i--) {

            if(arr[i] > arr[idx]) {

                resIdx = i;
                break;
            }
        }

        return resIdx;
    }

    public void nextPermutation(int[] arr) {

        int n = arr.length;

        if(n == 1) return;

        int pivotIdx = findIndexWhereArrayStartsDecreasing(arr);

        if(pivotIdx == -1) {

            reverse(arr, 0, arr.length - 1);
            return;
        }

        int firstGreaterThanPivotElementFromTheEnd = findFirstGreaterThanPivotElementFromTheEnd(arr, pivotIdx);

        swap(arr, pivotIdx, firstGreaterThanPivotElementFromTheEnd);
        reverse(arr, pivotIdx + 1, n - 1);
    }
}
