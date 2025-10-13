package com.Sortings;

import com.Sortings.BinaryInsertionSort.GenericBinaryInsertionSort;
import com.Sortings.RadixSort.RadixSort_using_BucketSort;

import java.util.*;

public class BucketSort {

    public void sort(int[] arr) {

        int n = arr.length;
        int maxValue = Arrays.stream(arr).max().orElse(0);

        Map<Integer, List<Integer>> bucket = new TreeMap<>(); // range based bucket

        for(int current : arr) {

            int bucketIdx = (current * n) / (maxValue + 1);
            bucket.computeIfAbsent(bucketIdx, k -> new ArrayList<>()).add(current);
        }

        int idx = 0;
        GenericBinaryInsertionSort<Integer> sorter = new GenericBinaryInsertionSort<>();

        for(List<Integer> list : bucket.values()) {

            sorter.sort(list);
            for(int num : list) {

                arr[idx++] = num;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 12, 21, 51, 90, 9, 18, 78, 42, 78, 44, 61, 23, 4, 56, 72};
        new BucketSort().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
