package com.DSA.TUF.Arrays.module_2;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicateElementsFromSortedArray(int[] arr) {

        int n = arr.length;

        int idx = 1;
        int previousEncounteredElement = arr[0];
        int numberOfUniqueElementsEncountered = 1;

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] == previousEncounteredElement) continue;

            arr[idx++] = arr[i];
            previousEncounteredElement = arr[i];

            numberOfUniqueElementsEncountered++;
        }

        return numberOfUniqueElementsEncountered;
    }
}
