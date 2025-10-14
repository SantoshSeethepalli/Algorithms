package com.DSA.TUF.Arrays.module_1;

import java.util.Arrays;

public class LeftRotateArrayByKPlaces {

    private void reverse(int[] arr, int start, int end) {

        while(start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public void leftRotateByKPlaces(int[] arr, int k) {

        int n = arr.length;
        k = k % n;

        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
}