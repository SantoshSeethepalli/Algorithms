package com.DSA.TUF.Arrays.module_1;

public class LargestElement {

    public int findLargestNumber(int[] arr) {

        int largestElementInArray = arr[0];

        for(int idx = 1; idx < arr.length; idx++) {

            largestElementInArray = Math.max(largestElementInArray, arr[idx]);
        }

        return largestElementInArray;
    }
}
