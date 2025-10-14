package com.DSA.GFG_MDQs.Arrays;

public class q2 {

    // https://www.geeksforgeeks.org/dsa/third-largest-element-array-distinct-elements/

    int thirdLargest(int[] arr) {

        if(arr.length < 3) return -1;

        int firstLargest = -1;
        int secondLargest = -1;
        int thirdLargest = -1;

        for(int num : arr) {

            if(num > firstLargest) {

                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = num;
            } else if(num > secondLargest) {

                thirdLargest = secondLargest;
                secondLargest = num;
            } else if(num > thirdLargest) {

                thirdLargest = num;
            }
        }

        return thirdLargest;
    }
}
