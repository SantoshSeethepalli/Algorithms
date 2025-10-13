package com.Sortings;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class CountingSort {

    // this algorithm is used to sort only integers that too small one's

    public void sort(int[] arr) {

        int minElement = Arrays.stream(arr).min().orElse(0);
        int maxElement = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        int[] countArray = new int[maxElement - minElement + 1];

        // perform counting
        for(int value : arr) countArray[value - minElement]++;

        int arrIdx = 0;
        for(int countArrayIdx = 0; countArrayIdx < countArray.length; countArrayIdx++) {

            while(countArray[countArrayIdx] > 0) {

                arr[arrIdx++] = countArrayIdx + minElement; // we stored it the other-way
                countArray[countArrayIdx]--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 2, 0, 3, 1, 1, 1, 2, 4, 3, 7, 1, 9, 2, 1, 1, 3, 5, 5, 5, 5, 6, 8, 6, 8};
        new CountingSort().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
