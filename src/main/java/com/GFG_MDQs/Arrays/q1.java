package com.GFG_MDQs.Arrays;

public class q1 {

    // https://www.geeksforgeeks.org/dsa/find-second-largest-element-array/

    public int getSecondLargest(int[] arr) {

        int firstLargest = -1;
        int secondLargest = Integer.MIN_VALUE;

        for(int num : arr) {

            if(num > firstLargest) {

                secondLargest = firstLargest;
                firstLargest = num;
            } else if(num > secondLargest && num != firstLargest) {

                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
