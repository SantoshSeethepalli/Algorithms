package com.DSA.TUF.Hashing.module_1;

import java.util.*;

public class ArrayHashing {

    int[] arr;
    int min;
    int max;
    int[] hashArray;

    // Constructor
    public ArrayHashing(int[] arr) {

        this.arr = arr;
        computeMinMax();
        computeHashArray();
    }

    private void computeMinMax() {

        if (arr == null || arr.length == 0) return;

        min = arr[0];
        max = arr[0];

        for (int element : arr) {
            if (element > max) max = element;
            if (element < min) min = element;
        }
    }

    private void initializeHashArray() {

        if (arr == null || arr.length == 0) {
            hashArray = new int[0];
            return;
        }

        int size = max - min + 1;
        hashArray = new int[size];
    }

    private void computeHashArray() {

        if (arr == null || arr.length == 0) return;

        initializeHashArray();

        for (int num : arr) {
            hashArray[num - min]++;
        }
    }

    public int getFrequency(int val) {

        if (hashArray == null || hashArray.length == 0) return 0;

        int idx = val - min;
        if (idx < 0 || idx >= hashArray.length) return 0;

        return hashArray[idx];
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        int[] arr = new int[size];

        for (int idx = 0; idx < size; idx++) {

            arr[idx] = scan.nextInt();
        }

        ArrayHashing hashHelper = new ArrayHashing(arr);

        int totalNumberOfQueries = scan.nextInt();
        List<Integer> queries = new ArrayList<>();

        for (int counter = 0; counter < totalNumberOfQueries; counter++) {

            queries.add(scan.nextInt());
        }

        for(int val : queries) {

            System.out.println(hashHelper.getFrequency(val));
        }
    }
}
