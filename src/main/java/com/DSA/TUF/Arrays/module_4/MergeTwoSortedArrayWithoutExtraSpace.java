package com.DSA.TUF.Arrays.module_4;

import java.util.*;

public class MergeTwoSortedArrayWithoutExtraSpace {

    private void swap(int[] arr1, int[] arr2, int i, int j) {

        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    public void merge(int[] arr1, int m, int[] arr2, int n) {

        int i = 0;
        int j = 0;

        while(i < (m - n) && j < n) {

            if(arr1[i] <= arr2[j]) {

                i++;
            } else {

                swap(arr1, arr2, i, j);
                i++;
            }
        }

        Arrays.sort(arr2);

        for(int idx = i; idx < m; idx++) {

            arr1[idx] = arr2[idx - i];
        }
    }

    public void simpleMerge(int[] arr1, int m, int[] arr2, int n) {

        int i = m - 1;      // last index of arr1's valid elements
        int j = n - 1;      // last index of arr2
        int k = m + n - 1;  // last position in arr1 (total length)

        while (i >= 0 && j >= 0) {

            if (arr1[i] > arr2[j]) arr1[k--] = arr1[i--];
            else arr1[k--] = arr2[j--];
        }

        while (j >= 0) {

            arr1[k--] = arr2[j--];
        }
    }
}
