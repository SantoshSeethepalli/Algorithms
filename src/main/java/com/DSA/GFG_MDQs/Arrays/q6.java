package com.DSA.GFG_MDQs.Arrays;

import java.util.*;

public class q6 {


    // https://www.geeksforgeeks.org/dsa/find-maximum-product-of-a-triplet-in-array/

    // better O(n*log(n))
    int maxProduct(int[] arr) {

        if(arr.length < 3) return 0;

        Arrays.sort(arr);

        int idx = arr.length - 1;

        return arr[idx] * arr[idx - 1] * arr[idx - 2];
    }

    // optima O(n)
    int maxProductOptimal(int[] arr) {

        if(arr.length < 3) return 0;

        long firstLargest = Long.MIN_VALUE;
        long secondLargest = Long.MIN_VALUE;
        long thirdLargest = Long.MIN_VALUE;

        long firstSmallest = Long.MAX_VALUE;
        long secondSmallest = Long.MAX_VALUE;

        for(int num : arr) {

            if(num > firstLargest) {

                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = (long) num;
            } else if(num > secondLargest) {

                thirdLargest = secondLargest;
                secondLargest = (long) num;
            } else if(num > thirdLargest) {

                thirdLargest = (long) num;
            }


            if(num < firstSmallest) {

                secondSmallest = firstSmallest;
                firstSmallest = num;
            } else if(num < secondSmallest) {

                secondSmallest = num;
            }
        }

        long product1 = firstLargest * secondLargest * thirdLargest;
        long product2 = firstLargest * firstSmallest * secondSmallest;

        return (int) Math.max(product1, product2);
    }
}
