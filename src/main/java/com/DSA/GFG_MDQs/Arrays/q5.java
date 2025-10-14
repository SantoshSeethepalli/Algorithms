package com.DSA.GFG_MDQs.Arrays;

public class q5 {

    // https://www.geeksforgeeks.org/dsa/array-rotation/

    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {

        while(i < j) {
            swap(arr, i++, j--);
        }
    }

    static void rotateArr(int[] arr, int d) {

        d = d % arr.length;

        reverse(arr, 0, d - 1);
        reverse(arr, d , arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
}
