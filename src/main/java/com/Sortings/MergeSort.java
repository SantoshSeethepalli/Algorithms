package com.Sortings;

import java.util.*;

public class MergeSort {

    // https://www.youtube.com/watch?v=4VqmGXwpLqc

    /*
        This algorithm is follows the Divide and Conquer paradigm

        divide the array into small parts (literally until single element),
        then compare element and place them accordingly (small to left and larger to right)

        we deal with indices here we don't actually split the array,
        Remember that you used to get confused that how can someone split the array, don't get confused again
     */

    public int[] mergeSort(int[] arr) {

        sort(arr, 0, arr.length - 1);

        return arr;
    }

    private void sort(int[] arr, int left, int right) {

        if(left == right) return;

        int mid = (left + right) / 2;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {

        // copy elements into the sub array's
        List<Integer> leftSubArray = new ArrayList<>();
        List<Integer> rightSubArray = new ArrayList<>();

        for(int i = left; i <= mid; i++) leftSubArray.add(arr[i]);
        for(int i = mid + 1; i <= right; i++) rightSubArray.add(arr[i]);

        // compare the elements in the sub-arrays and add them back into original array (in sorted order)

        int i = 0;
        int j = 0;
        int originalIdx = left;

        while(i < leftSubArray.size() && j < rightSubArray.size()) {

            int element = 0;

            if(leftSubArray.get(i) < rightSubArray.get(j)) {

                element = leftSubArray.get(i);
                i++;
            } else {

                element = rightSubArray.get(j);
                j++;
            }

            arr[originalIdx++] = element;
        }

        while(i < leftSubArray.size()) {

            arr[originalIdx++] = leftSubArray.get(i++);
        }

        while(j < rightSubArray.size()) {

            arr[originalIdx++] = rightSubArray.get(j++);
        }
    }
}