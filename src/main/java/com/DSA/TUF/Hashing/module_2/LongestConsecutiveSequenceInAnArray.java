package com.DSA.TUF.Hashing.module_2;

import java.util.*;

public class LongestConsecutiveSequenceInAnArray {

    public int findLongestConsecutiveSequenceInAnArray(int[] arr) {

        Set<Integer> hashSet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {

            hashSet.add(num);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int maxLength = 0;
        int counter = 0;

        for (int num = min; num <= max; num++) {

            if (!hashSet.contains(num)) {

                maxLength = Math.max(maxLength, counter);
                counter = 0;
                continue;
            }

            System.out.println(num);
            counter++;
        }

        maxLength = Math.max(maxLength, counter);

        System.out.println("\n\n");

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(new LongestConsecutiveSequenceInAnArray().findLongestConsecutiveSequenceInAnArray(arr));
    }
}
