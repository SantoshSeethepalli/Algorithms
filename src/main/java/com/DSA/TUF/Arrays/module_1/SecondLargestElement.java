package com.DSA.TUF.Arrays.module_1;

public class SecondLargestElement {

    public int findSecondLargestElement(int[] arr) {

        int largestElementInArray = Integer.MIN_VALUE;
        int secondLargestElementInArray = Integer.MIN_VALUE;

        for(int num : arr) {

            if(num > largestElementInArray) {

                secondLargestElementInArray = largestElementInArray;
                largestElementInArray = num;
            } else if(num != largestElementInArray && num > secondLargestElementInArray) {

                secondLargestElementInArray = num;
            }
        }

        return (secondLargestElementInArray == Integer.MIN_VALUE) ? -1 : secondLargestElementInArray;
    }
}
