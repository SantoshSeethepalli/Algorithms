package com.DSA.GFG_MDQs.Arrays;

public class q7 {

    // https://www.geeksforgeeks.org/dsa/maximum-consecutive-ones-or-zeros-in-a-binary-array/

    public int maxConsecBits(int[] arr) {

        if (arr.length == 0) return 0;

        int previous = arr[0];
        int count = 1;
        int maxCount = 1;

        for (int idx = 1; idx < arr.length; idx++) {

            if (previous == arr[idx]) {

                count++;
            } else {

                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            previous = arr[idx];
        }

        maxCount = Math.max(maxCount, count);

        return maxCount;
    }
}
