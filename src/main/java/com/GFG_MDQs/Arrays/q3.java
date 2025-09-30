package com.GFG_MDQs.Arrays;

public class q3 {

    // https://www.geeksforgeeks.org/dsa/program-to-reverse-an-array/

    public void reverseArray(int[] arr) {

        for(int i = 0; i < arr.length / 2; i++) {
            swap(i, arr.length - 1 - i, arr);
        }
    }

    private void swap(int i, int j, int[] nums) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
