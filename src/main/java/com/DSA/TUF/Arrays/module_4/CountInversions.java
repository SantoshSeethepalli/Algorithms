package com.DSA.TUF.Arrays.module_4;

import java.util.*;

public class CountInversions {

    public long getInversionCount(int[] arr) {

       return countInversions(arr, 0, arr.length - 1);
    }

    private long countInversions(int[] arr, int left, int right) {

        if(left >= right) return 0;

        int mid = (left + right) / 2;

        long count = 0;

        count += countInversions(arr, left, mid);
        count += countInversions(arr, mid + 1, right);

        count += findInversions(arr, left, mid, right);

        return count;
    }

    private long findInversions(int[] arr, int left, int mid, int right) {

        List<Integer> leftSubArray = new ArrayList<>();
        List<Integer> rightSubArray = new ArrayList<>();

        for(int i = left; i <= mid; i++) leftSubArray.add(arr[i]);
        for(int i = mid + 1; i <= right; i++) rightSubArray.add(arr[i]);

        int i = 0;
        int j = 0;
        int idx = left;

        long count = 0;

        while(i < leftSubArray.size() && j < rightSubArray.size()) {

            if(leftSubArray.get(i) > rightSubArray.get(j)) {

                arr[idx++] = rightSubArray.get(j++);
                count += (long) leftSubArray.size() - i;
            } else {

                arr[idx++] = leftSubArray.get(i++);
            }
        }

        while(i < leftSubArray.size()) {

            arr[idx++] = leftSubArray.get(i++);
        }

        while(j < rightSubArray.size()) {

            arr[idx++] = rightSubArray.get(j++);
        }

        return count;
    }
}
