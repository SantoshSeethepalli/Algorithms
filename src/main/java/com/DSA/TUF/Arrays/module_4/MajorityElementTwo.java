package com.DSA.TUF.Arrays.module_4;

import java.util.*;

public class MajorityElementTwo {

    public List<Integer> getElementsWithFrequencyAboveNDiv3(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        // find frequency
        for(int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        int threshold = arr.length / 3;
        List<Integer> elementWithFrequencyGreaterThanThreshold = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()) {

            if(entrySet.getValue() <= threshold) continue;

            int value = entrySet.getKey();
            elementWithFrequencyGreaterThanThreshold.add(value);
        }

        return elementWithFrequencyGreaterThanThreshold;
    }
}
