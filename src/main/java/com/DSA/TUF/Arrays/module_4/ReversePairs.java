package com.DSA.TUF.Arrays.module_4;

import java.util.*;

public class ReversePairs {

    // Brute-force
    public int countReversPairs_BruteForce(int[] arr) {

        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {

                if(arr[i] > 2 * arr[j]) count++;
            }
        }

        return count;
    }

    public int countReversPairs(int[] arr) {

        return countReversPairs(arr, 0, arr.length - 1);
    }

    private int countReversPairs(int[] arr, int left, int right) {

        if(left >= right) return 0;

        int mid = (left + right) / 2;

        int count = 0;

        count += countReversPairs(arr, left, mid);
        count += countReversPairs(arr, mid + 1, right);

        count += findCount(arr, left, mid, right);
        merge(arr, left, mid, right);

        return count;
    }

    private int findCount(int[] arr, int left, int mid, int right) {

        long count = 0;

        int rightPointer = mid + 1;
        for(int leftPointer = left; leftPointer <= mid; leftPointer++) {

            while(rightPointer <= right && (long) arr[leftPointer] > 2L * arr[rightPointer]) {

                rightPointer++;
            }

            count += (rightPointer - (mid + 1));
        }

        return (int) count;
    }

    private void merge(int[] arr, int left, int mid, int right) {

        List<Integer> leftSubArray = new ArrayList<>();
        List<Integer> rightSubArray = new ArrayList<>();

        for(int i = left; i <= mid; i++) leftSubArray.add(arr[i]);
        for(int i = mid + 1; i <= right; i++) rightSubArray.add(arr[i]);

        int i = 0;
        int j = 0;
        int idx = left;

        while(i < leftSubArray.size() && j < rightSubArray.size()) {

            if(leftSubArray.get(i) <= rightSubArray.get(j)) {

                arr[idx++] = leftSubArray.get(i++);
            } else {

                arr[idx++] = rightSubArray.get(j++);
            }
        }

        while(i < leftSubArray.size()) {

            arr[idx++] = leftSubArray.get(i++);
        }

        while(j < rightSubArray.size()) {

            arr[idx++] = rightSubArray.get(j++);
        }
    }
}
