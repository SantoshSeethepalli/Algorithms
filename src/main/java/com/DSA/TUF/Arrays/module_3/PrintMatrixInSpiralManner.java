package com.DSA.TUF.Arrays.module_3;

import java.util.*;

public class PrintMatrixInSpiralManner {

    // focus on inner if's: the (top, bottom) & (left, right) might cross each other in the first two for loops hence we need to check

    public List<Integer> getSpiralList(int[][] matrix) {

        List<Integer> spiralMatrix = new ArrayList<>();

        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while(left <= right && top <= bottom) {

            for(int j = left; j <= right; j++) {

                spiralMatrix.add(matrix[top][j]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {

                spiralMatrix.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {

                for(int j = right; j >= left; j--) {

                    spiralMatrix.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left <= right) {

                for(int i = bottom; i >= top; i--) {

                    spiralMatrix.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiralMatrix;
    }
}
