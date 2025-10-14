package com.DSA.TUF.Arrays.module_3;

public class RotateMatrixByNinteyDegrees {

    private void swapArrayElements(int[][] arr, int i, int j, int a, int b) {

        int temp = arr[i][j];
        arr[i][j] = arr[a][b];
        arr[a][b] = temp;
    }

    public void rotateMatrix(int[][] matrix) {

        int numOfRows = matrix.length;
        int numOfColoums = matrix[0].length;

        for(int i = 0; i < numOfRows; i++) {

            for(int j = 0; j < i; j++) {

                swapArrayElements(matrix, i, j, j, i);
            }
        }

        for(int j = 0; j < numOfColoums / 2; j++) {
            for(int i = 0; i < numOfRows; i++) {

                swapArrayElements(matrix, i, j, i, numOfColoums - 1 - j);
            }
        }
    }
}
