package com.DSA.TUF.Arrays.module_4;

import java.util.Arrays;

public class FindRepeatedAndMissingNumber {

    public int[] findMissingRepeatingNumbers(int[] arr) {

        int n = arr.length;

        long actualSum = 0;
        long actualSquaredSum = 0;

        for(int num : arr) {

            actualSum += num;
            actualSquaredSum += (long) num * num;
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquaredSum = (long)n * (n + 1) *(2* n + 1) / 6;

        long differenceOfTwoNumbers = actualSum - expectedSum; //
        long sumOfTwoNumbers = (actualSquaredSum - expectedSquaredSum) / (actualSum - expectedSum); // To find (actualSum + expectedSum) 31 + 28

        int repeatedNumber = (int) ((sumOfTwoNumbers + differenceOfTwoNumbers) / 2);
        int missingNumber = (int) ((sumOfTwoNumbers - differenceOfTwoNumbers) / 2);

        return new int[]{repeatedNumber, missingNumber};
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 6, 7, 5, 7};

        System.out.println(Arrays.toString(new FindRepeatedAndMissingNumber().findMissingRepeatingNumbers(arr)));
    }
}
