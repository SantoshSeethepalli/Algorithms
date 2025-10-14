package com.DSA.TUF.Arrays.module_4;

public class MaximumProductSubArray {

    public int findMaxProductSubArray(int[] arr) {

        int maxProduct = Integer.MIN_VALUE;
        int currentProduct = 1;

        for(int idx = 0; idx < arr.length; idx++) {

            currentProduct *= arr[idx];
            maxProduct = Math.max(maxProduct, currentProduct);

            if(currentProduct == 0) currentProduct = 1;
        }

        currentProduct = 1;
        for(int idx = arr.length - 1; idx >= 0; idx--) {


            currentProduct *= arr[idx];
            maxProduct = Math.max(maxProduct, currentProduct);

            if(currentProduct == 0) currentProduct = 1;
        }

        return maxProduct;
    }
}
