package com.DSA.TUF.Arrays.module_1;

public class LeftRotateArrayByOne {

    public void leftRotateByOnePosition(int[] arr){

        int lastElementAfterRotation = arr[0];

        for(int i = 1; i < arr.length; i++) {

            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = lastElementAfterRotation;
    }
}
