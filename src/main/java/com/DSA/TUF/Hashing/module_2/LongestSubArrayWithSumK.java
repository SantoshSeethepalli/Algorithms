package com.DSA.TUF.Hashing.module_2;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

    public int longestSubarrayOnlyPositive(int[] arr, int k) {

        int left = 0;

        int longestSubArrayLength = 0;
        int sum = 0;

        for(int right = 0; right < arr.length; right++) {

            sum += arr[right];

            if(sum == k) {

                longestSubArrayLength = Math.max(longestSubArrayLength, right - left + 1);
            }
            while(left <= right && sum > k) {

                sum -= arr[left++];
            }
        }

        return longestSubArrayLength;
    }

    public int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> prefixSumIndexMap = new HashMap<>();

        int longestSubarray = 0;
        int sum = 0;

        for(int idx = 0; idx < arr.length; idx++) {

            sum += arr[idx];

            if (sum == k) {

                longestSubarray = Math.max(longestSubarray, idx + 1);
            }

            int remainingSum = sum - k;

            if(prefixSumIndexMap.containsKey(remainingSum)) {

                int subArrayLengthExcludingRemainingSum = idx - prefixSumIndexMap.get(remainingSum);
                longestSubarray = Math.max(longestSubarray, subArrayLengthExcludingRemainingSum);
            }

            if(!prefixSumIndexMap.containsKey(sum)) {

                prefixSumIndexMap.put(sum, idx);
            }
        }

        return longestSubarray;
    }

    public static void main(String[] args) {

        int[] arr = {-64,-306,883,-343,34,518,227,170,-471,721,648,349,-480,524,-144,-811,-809,125,-500,117,451,156,913,688};
        System.out.println(new LongestSubArrayWithSumK().longestSubarray(arr, 2208));
    }
}