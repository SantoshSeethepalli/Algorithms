package com.DSA.TUF.Arrays.module_3;

public class Sort012 {

    private void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortO12(int[] arr) {

        int n = arr.length;

        int zeroPointer = 0;
        int onePointer = 0;
        int twoPointer = n - 1;

        while(onePointer <= twoPointer) {

            if(arr[onePointer] == 0) {

                swap(arr, onePointer++, zeroPointer++);
            } else if(arr[onePointer] == 2) {

                swap(arr, onePointer, twoPointer--);
            } else {

                onePointer++;
            }
        }
    }
}
