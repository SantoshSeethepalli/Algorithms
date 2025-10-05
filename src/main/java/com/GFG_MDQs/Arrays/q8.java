package com.GFG_MDQs.Arrays;

public class q8 {

    // https://www.geeksforgeeks.org/dsa/move-zeroes-end-array/

    void swap(int[] arr, int i, int j) {

        if(i >= arr.length || j >= arr.length) return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void pushZerosToEnd(int[] arr) {

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] != 0) continue;

            int idx = i;
            while(idx < arr.length && arr[idx] == 0) idx++;

            swap(arr, i, idx);
        }
    }
}
