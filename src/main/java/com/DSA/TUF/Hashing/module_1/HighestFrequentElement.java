package com.DSA.TUF.Hashing.module_1;

import java.util.Arrays;
import java.util.HashSet;

public class HighestFrequentElement {

    // works only positive numbers
    public int highestFrequentElement(int[] arr) {

        int max = Arrays.stream(arr).max().orElse(10^4 + 1);

        int[] hashArray = new int[max + 1];
        for(int num : arr) hashArray[num]++;

        // if two numbers have same frequency then number with small value is considered
        int leastValuedMostFrequentElement = -1;
        int maxFrequencyFound = Integer.MIN_VALUE;

        for(int key = 0; key < hashArray.length; key++) {

            int value = hashArray[key];

            if(value > maxFrequencyFound) {

                maxFrequencyFound = value;
                leastValuedMostFrequentElement = key;
            }
        }

        return leastValuedMostFrequentElement;
    }
}
