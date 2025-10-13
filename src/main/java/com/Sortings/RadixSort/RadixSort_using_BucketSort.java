package com.Sortings.RadixSort;

import com.Sortings.BinaryInsertionSort.GenericBinaryInsertionSort;

import java.util.*;

public class RadixSort_using_BucketSort<T extends Comparable<? super T>> {

    private void bucketSort(int[] arr, int place) {

        Map<Integer, List<Integer>> bucket = new TreeMap<>();

        // compute buckets
        for (int current : arr) {

            int bucketIdx = (current / place) % 10;

            if (bucket.containsKey(bucketIdx)) {

                List<Integer> listAtBucketIdx = bucket.get(bucketIdx);
                listAtBucketIdx.add(current);

                bucket.put(bucketIdx, listAtBucketIdx);
            } else {

                bucket.put(bucketIdx, new ArrayList<>(List.of(current)));
            }
        }

        int idx = 0;
        GenericBinaryInsertionSort<Integer> sorter = new GenericBinaryInsertionSort<>();

        for(int i = 0; i < 10; i++) {

            List<Integer> listAtBucketIdx = bucket.getOrDefault(i, Collections.emptyList()); // else use new ArrayList<>();

            if(!listAtBucketIdx.isEmpty()) {

//                sorter.sort(listAtBucketIdx); not necessary as we are using TreeMap
                idx = addToArray(idx, arr, listAtBucketIdx);
            }
        }
    }

    private int addToArray(int idx, int[] arr, List<Integer> list) {

        for(int num : list) {
            arr[idx++] = num;
        }

        return idx;
    }

    public void sort(int[] arr) {

        int maxValue = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        for (int digitPlace = 1; (maxValue / digitPlace) > 0; digitPlace *= 10) {

            bucketSort(arr, digitPlace);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 12, 21, 51, 90, 9, 18, 78, 42, 78, 44, 61, 23, 4, 56, 72};
        new RadixSort_using_BucketSort<>().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
