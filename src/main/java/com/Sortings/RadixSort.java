package com.Sortings;

import java.util.*;

public class RadixSort {

    // we are performing LSB radix sort, means the right to left the comparison is being done.

    // Best one: https://www.youtube.com/watch?v=ujb2CIWE8zY
    // Good to refer: https://www.youtube.com/watch?v=GhP5WbE4GYo&t=1s

    private void helperCountingSort(List<Integer> arr, int digitPlaceInReverseOrder) {

        int[] countArray = new int[10];

        // perform counting
        for(int value : arr) countArray[(value / digitPlaceInReverseOrder) % 10]++;

        // compute prefixSum
        for(int i = 1; i < 10; i++) countArray[i] += countArray[i  - 1];

        int[] output = new int[arr.size()];

        for(int i = arr.size() - 1; i >= 0; i--) {

            int current = arr.get(i);
            int unitsPlaceValue = (current / digitPlaceInReverseOrder) % 10;

            countArray[unitsPlaceValue]--;
            int positionInArray = countArray[unitsPlaceValue];

            output[positionInArray] = current;
        }

        arr.clear();
        for(int value : output) arr.add(value);
    }

    private void radixSort(List<Integer> arr, int maxElement) {

        // this loop will run for maximum of max-length digit size.
        for(int digitPlaceInReverseOrder = 1; (maxElement / digitPlaceInReverseOrder) > 0; digitPlaceInReverseOrder *= 10) {

            helperCountingSort(arr, digitPlaceInReverseOrder);
        }
    }

    public void sort(int[] arr) {

        List<Integer> negativeValues = new ArrayList<>();
        List<Integer> positiveValues = new ArrayList<>();

        // separate positive and negative integers(absolute values)
        for(int num : arr) {

            if(num < 0) {

                negativeValues.add(-num);
            } else {

                positiveValues.add(num);
            }
        }

        // Handle positives
        int maxPositive = positiveValues.isEmpty() ? 0 : Collections.max(positiveValues);
        radixSort(positiveValues, maxPositive);

        int maxNegative = negativeValues.isEmpty() ? 0 : Collections.max(negativeValues);
        radixSort(negativeValues, maxNegative);

        // restore sign and order as we stored absolute values in negativeValues
        Collections.reverse(negativeValues);
        negativeValues.replaceAll(integer -> -integer);

        // Merge negatives and positives
        negativeValues.addAll(positiveValues);

        for(int i = 0; i < arr.length; i++) {

            arr[i] = negativeValues.get(i);
        }
    }

    public static void main(String[] args) {

        int[] arr = {132, 352, 123, 425, -112};

        new RadixSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
