package com.DSA.TUF.Arrays.module_1;

public class MaximumConsecutiveOnes {

    public int findMaximumConsecutiveOnes(int[] arr) {

        int maxConsecutiveOnes = 0;
        int consecutiveOnesCounter = 0;

        for (int num : arr) {

            if (num == 0) {

                consecutiveOnesCounter = 0;
                continue;
            }

            consecutiveOnesCounter++;
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, consecutiveOnesCounter);
        }

        return maxConsecutiveOnes;
    }
}
