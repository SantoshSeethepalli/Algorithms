package com.DSA.TUF.Arrays.module_3;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] arr) {

        int n = arr.length;

        if(n < 3) return new ArrayList<>();

        Map<Integer, List<Integer>> valueIndicesMap = findValueIndicesMap(arr);
        Set<List<Integer>> uniqueTriples = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                int remainingSum = -(arr[i] + arr[j]);

                if(valueIndicesMap.containsKey(remainingSum)) {

                    computeTripletsForGivenIndices(i, j, valueIndicesMap.get(remainingSum), arr, uniqueTriples);
                }
            }
        }

        return new ArrayList<>(uniqueTriples);
    }

    private void computeTripletsForGivenIndices(int i, int j, List<Integer> indicesList, int[] arr, Set<List<Integer>> uniqueTriplets) {

        for (int idx : indicesList) {

            if (idx == i || idx == j) continue;

            List<Integer> triplet = new ArrayList<>(List.of(arr[i], arr[j], arr[idx]));

            Collections.sort(triplet);

            uniqueTriplets.add(triplet);
        }
    }

    private Map<Integer, List<Integer>> findValueIndicesMap(int[] arr) {

        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {

            hashMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        return hashMap;
    }
}
