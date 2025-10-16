package com.DSA.TUF.Hashing.module_2;

import java.util.*;

public class CountSubArraysWithGivenXorK {
    public int countSubArraysWithXorEqualsK(int[] arr, int target) {

        Map<Integer, Integer> prefixXor = new HashMap<>();
        int count = 0;
        int xorSum = 0;

        for(int num : arr) {

            xorSum ^= num;

            if(xorSum == target) count++;

            int required = xorSum ^ target;

            count += prefixXor.getOrDefault(required, 0);
            prefixXor.put(xorSum, prefixXor.getOrDefault(xorSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 2, 2, 6, 4};
        int[] arr2 = {5, 6, 7, 8, 9};
        int[] arr3 = {5, 2, 9};

        CountSubArraysWithGivenXorK object = new CountSubArraysWithGivenXorK();

        System.out.println(object.countSubArraysWithXorEqualsK(arr1, 6));
        System.out.println(object.countSubArraysWithXorEqualsK(arr2, 5));
        System.out.println(object.countSubArraysWithXorEqualsK(arr3, 7));
    }
}
