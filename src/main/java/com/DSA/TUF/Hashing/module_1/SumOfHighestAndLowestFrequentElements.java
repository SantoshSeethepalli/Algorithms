package com.DSA.TUF.Hashing.module_1;

import java.util.Arrays;

public class SumOfHighestAndLowestFrequentElements {

    public int sumOfHighestAndLowestFrequentElements(int[] arr) {

        int max = Arrays.stream(arr).max().orElse(10^4 + 1);
        int[] hashArray = new int[max + 1];

        for(int num : arr) hashArray[num]++;

        int maxFrequency = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        int maxFrequencyElement = -1;
        int minFrequencyElement = -1;

        for(int key = 0; key < hashArray.length; key++) {

            int value = hashArray[key];

            if(value > maxFrequency) {

                maxFrequencyElement = key;
                maxFrequency = value;
            } else if(value < minFrequency) {

                minFrequencyElement = key;
                minFrequency = value;
            }
        }

        return maxFrequencyElement + minFrequencyElement;
    }
}
