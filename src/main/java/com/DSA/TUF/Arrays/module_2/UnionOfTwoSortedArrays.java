package com.DSA.TUF.Arrays.module_2;

import java.util.*;

public class UnionOfTwoSortedArrays {

    public int[] findUnion(int[] arr1, int[] arr2) {

        Set<Integer> set = new TreeSet<>();

        for(int num : arr1) set.add(num);
        for(int num : arr2) set.add(num);

        int[] unionArray = new int[set.size()];

        int idx = 0;
        for(int uniqueValue : set) {

            unionArray[idx++] = uniqueValue;
        }

        return unionArray;
    }
}
