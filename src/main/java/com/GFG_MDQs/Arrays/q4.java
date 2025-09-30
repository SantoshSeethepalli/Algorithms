package com.GFG_MDQs.Arrays;

public class q4 {

    // https://www.geeksforgeeks.org/problems/reverse-array-in-groups0255/1

    public void reverseInGroups(int[] nums, int k) {

        for(int i = 0; i < nums.length; i += k) {

            if(i + k >= nums.length) {

                reverse(nums, i, nums.length - 1);
                break;
            }

            reverse(nums, i, i + k - 1);
        }
    }

    private void reverse(int[] nums, int i, int j) {

        while(i < j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}
