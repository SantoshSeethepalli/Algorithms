package com.DSA.TUF.Hashing.module_1;

import java.util.Arrays;

public class SecondHighestFrequentElement {

    public int secondHighestFrequentElement(int[] arr) {

        int max = Arrays.stream(arr).max().orElse(10^4 + 1);
        int[] hashArray = new int[max + 1];

        for(int num : arr) hashArray[num]++;

        System.out.println(Arrays.toString(hashArray));

        int maxFrequentElement = Integer.MIN_VALUE;
        int maxFrequency = -1;

        int secondMaxFrequentElement = Integer.MIN_VALUE;
        int secondMaxFrequency = -1;

        for(int key = 0; key < hashArray.length; key++) {

            int value = hashArray[key];

            if(value > maxFrequency) {

                secondMaxFrequency = maxFrequency;
                secondMaxFrequentElement = maxFrequentElement;

                maxFrequentElement = key;
                maxFrequency = value;
            } else if(value != maxFrequency && value > secondMaxFrequency) {

                secondMaxFrequentElement = key;
                secondMaxFrequency = hashArray[key];
            }
        }

        return secondMaxFrequentElement;
    }
}
