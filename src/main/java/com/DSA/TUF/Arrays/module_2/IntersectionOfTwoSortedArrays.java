package com.DSA.TUF.Arrays.module_2;

import java.util.*;

public class IntersectionOfTwoSortedArrays {

    private int[] getArray(List<Integer> arr) {

        int[] output = new int[arr.size()];

        for(int idx = 0; idx < arr.size(); idx++) {

            output[idx] = arr.get(idx);
        }

        return output;
    }

    public int[] findIntersection(int[] arr1, int[] arr2) {

        Map<Integer, Integer> firstArray = new HashMap<>();

        for (int num : arr1) firstArray.put(num, firstArray.getOrDefault(num, 0) + 1);

        List<Integer> unionList = new ArrayList<>();

        for(int num : arr2) {

            if(firstArray.containsKey(num)) {

                unionList.add(num);

                firstArray.put(num, firstArray.get(num) - 1);
                if(firstArray.get(num) == 0) firstArray.remove(num);
            }
        }

        return getArray(unionList);
    }
}
