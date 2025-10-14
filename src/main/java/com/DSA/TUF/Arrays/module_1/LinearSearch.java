package com.DSA.TUF.Arrays.module_1;

public class LinearSearch {

    public int linearSearch(int[] arr, int target) {

        for(int idx = 0; idx < arr.length; idx++) {

            if(arr[idx] == target) {
                return idx;
            }
        }

        return -1;
    }
}
