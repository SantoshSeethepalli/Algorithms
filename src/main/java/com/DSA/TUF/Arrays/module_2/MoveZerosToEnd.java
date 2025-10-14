package com.DSA.TUF.Arrays.module_2;

import java.util.Arrays;

public class MoveZerosToEnd {

    public void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int findNextNonZeroIdx(int[] arr, int idx) {

        while(idx < arr.length && arr[idx] == 0) {

            idx++;
        }
        return idx;
    }

    public void stableMoveZerosToEnd(int[] arr) {

        int n = arr.length;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] != 0) continue;

            int nextNonZeroElementIdx = findNextNonZeroIdx(arr, i);

            if(nextNonZeroElementIdx == arr.length) break;

            swap(arr, i, nextNonZeroElementIdx);
        }
    }
}
