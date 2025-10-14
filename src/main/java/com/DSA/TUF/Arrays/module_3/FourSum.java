package com.DSA.TUF.Arrays.module_3;

import java.util.*;

public class FourSum {

    private int findNextValidIndex(int[] arr, int idx, boolean moveRight) {

        int updater = 1;
        if(!moveRight) updater = -updater;
        int initialValue = arr[idx];

        while(idx < arr.length && idx >= 0 &&
                arr[idx] == initialValue) {

            idx += updater;
        }

        return idx;
    }

    public List<List<Integer>> fourSum(int[] arr, int target) {

        if(arr.length < 4) return new ArrayList<>();

        Arrays.sort(arr);

        Set<List<Integer>> uniqueQuadruplets = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {

                int k = j + 1;
                int l = arr.length - 1;

                while(k < l && k < arr.length) {

                    int sum = arr[i] + arr[j] + arr[k] + arr[l];

                    if(sum == target) {

                        uniqueQuadruplets.add(new ArrayList<>(List.of(arr[i], arr[j], arr[k], arr[l])));

                        k = findNextValidIndex(arr, k, true);
                        l = findNextValidIndex(arr, l, false);
                    } else if(sum < target) {

                        k = findNextValidIndex(arr, k, true);
                    } else {

                        l = findNextValidIndex(arr, l, false);
                    }
                }
            }
        }

        return new ArrayList<>(uniqueQuadruplets);
    }
}
