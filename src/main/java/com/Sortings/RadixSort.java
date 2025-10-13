package com.Sortings;

import java.util.*;

public class RadixSort {

    // we are performing LSB radix sort, means the right to left the comparision is being done.

    private void helperCountingSort(List<Integer> arr, int exp) {

        int[] countArray = new int[10];

        // perform counting
        for(int value : arr) countArray[(value / exp) % 10]++;
        for(int i = 1; i < 10; i++) countArray[i] += countArray[i  - 1];

        int[] output = new int[arr.size()];

        for(int i = arr.size() - 1; i >= 0; i--) {

            int current = arr.get(i);
            int positionInArray = countArray[(current / exp) % 10] - 1;

            output[positionInArray] = current;
            countArray[((current / exp) % 10)]--;
        }

        arr.clear();
        for(int value : output) arr.add(value);
    }

    private void radixSort(List<Integer> arr, int max) {

        for(int exp = 1; (max / exp) > 0; exp *= 10) {

            helperCountingSort(arr, exp);
        }
    }

    public void sort(int[] arr) {

        List<Integer> negativeIntegers = new ArrayList<>();
        List<Integer> positiveIntegers = new ArrayList<>();

        for(int num : arr) {

            if(num < 0) {

                negativeIntegers.add(num);
            } else {

                positiveIntegers.add(num);
            }
        }

        // Handle positives
        int maxPositive = positiveIntegers.isEmpty() ? 0 : Collections.max(positiveIntegers);
        radixSort(positiveIntegers, maxPositive);

        // Handle negatives
        List<Integer> absNegatives = new ArrayList<>();
        for(int num : negativeIntegers) absNegatives.add(-num);

        int maxNegative = absNegatives.isEmpty() ? 0 : Collections.max(absNegatives);
        radixSort(absNegatives, maxNegative);

        // restore sign and order
        Collections.reverse(absNegatives);
        for(int i = 0; i < absNegatives.size(); i++) {

            absNegatives.set(i, -absNegatives.get(i));
        }

        // Merge negatives and positives
        absNegatives.addAll(positiveIntegers);

        for(int i = 0; i < arr.length; i++) {

            arr[i] = absNegatives.get(i);
        }
    }

    public static void main(String[] args) {

        int[] arr = {132, 352, 123, 425, -112};

        new RadixSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
