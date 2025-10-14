package com.DSA.TUF.Arrays.module_4;

public class MajorityElementOne {

    public int findMostFrequentElement(int[] arr) {

        int frequentElement = arr[0];
        int frequentElementFrequency = 0;

        for(int idx = 0; idx < arr.length; idx++) {

            if(arr[idx] == frequentElement) frequentElementFrequency++;
            else frequentElementFrequency--;

            if(frequentElementFrequency == 0) {

                frequentElement = arr[idx + 1];
            }
        }

        return frequentElement;
    }
}
