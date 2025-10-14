package com.DSA.TUF.Arrays.module_3;

import java.util.*;

public class TwoSum {

    private int[] twoSum(int[] arr, int target) {

        int n = arr.length;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int idx = 0; idx < n; idx++) {

            hashMap.put(arr[idx], idx);
        }

        for(int idx = 0; idx < n; idx++) {

            int remainingSum = target - arr[idx];

            if(hashMap.containsKey(remainingSum)) {

                if(hashMap.get(remainingSum) == idx) continue;

                int maxIdx = Math.max(idx, hashMap.get(remainingSum));
                int minIdx = Math.min(idx, hashMap.get(remainingSum));

                return new int[]{minIdx, maxIdx};
            }
        }

        return new int[]{-1, -1};
    }
}
