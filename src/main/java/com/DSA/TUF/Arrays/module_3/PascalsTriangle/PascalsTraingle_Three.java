package com.DSA.TUF.Arrays.module_3.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingle_Three {

    public List<List<Integer>> pascalTriangleIII(int n) {

        List<List<Integer>> triangle = new ArrayList<>();

        for(int row = 1; row <= n; row++) {

            List<Integer> currentRow = new ArrayList<>();
            int currentValue = 1;

            currentRow.add(currentValue);

            for(int coloum = 1; coloum < row; coloum++) {

                currentValue = currentValue * (row - coloum);
                currentValue = currentValue / coloum;

                currentRow.add(currentValue);
            }

            triangle.add(currentRow);
        }

        return triangle;
    }
}
