package com.DSA.TUF.Hashing.module_2;

import java.util.*;

public class CountSubArraysWithGivenSum {

    public int countSubArraysWithGivenSumOnlyPositive(int[] arr, int target) {

        int count = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int left = 0;

        for(int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while(left < right && sum > target) {

                sum -= arr[left++];
            }

            if(sum == target) {

                count++;
            }
        }

        return count;
    }

    public int countSubArraysWithGivenSum(int[] arr, int target) {


        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int sum = 0;

        prefixSumMap.put(0, 1); // one way to get sum 0

        for(int num : arr) {

            sum += num;

            int remainingSum = sum - target;

            count += prefixSumMap.getOrDefault(remainingSum, 0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 1, 2, 4};

        CountSubArraysWithGivenSum object = new CountSubArraysWithGivenSum();

        System.out.println(object.countSubArraysWithGivenSum(arr1, 2));
        System.out.println(object.countSubArraysWithGivenSum(arr2, 3));
        System.out.println(object.countSubArraysWithGivenSum(arr3, 6));
    }
}
