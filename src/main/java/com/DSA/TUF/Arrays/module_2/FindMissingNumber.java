package com.DSA.TUF.Arrays.module_2;

public class FindMissingNumber {

    public int findMissingNumber(int[] arr) {

        int n = arr.length;

        int actualSum = 0;
        int expectedSum = n * (n + 1) / 2;

        for(int idx = 0; idx < arr.length; idx++) {

            actualSum += arr[idx];
        }

        return (expectedSum - actualSum);
    }

    public int findMissingNumberUsingBitManipulation(int[] arr) {

        int n = arr.length;

        int actualXorSum = 0;
        int expectedXorSum = 0;

        for(int idx = 0; idx < arr.length; idx++) {

            actualXorSum ^= arr[idx];
            expectedXorSum ^= (idx + 1);
        }

        return (expectedXorSum ^ actualXorSum);
    }
}
