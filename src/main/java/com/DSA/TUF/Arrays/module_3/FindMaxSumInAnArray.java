package com.DSA.TUF.Arrays.module_3;

public class FindMaxSumInAnArray {

    public int findMaxSumSubArray(int[] arr) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {

            sum += num;

            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0;
        }

        return maxSum;
    }
}
