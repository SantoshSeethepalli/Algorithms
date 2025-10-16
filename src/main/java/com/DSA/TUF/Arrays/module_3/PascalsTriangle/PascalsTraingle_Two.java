package com.DSA.TUF.Arrays.module_3.PascalsTriangle;

import java.util.Arrays;

public class PascalsTraingle_Two {

    public int[] pascalTriangleII(int r) {

        int[] res = new int[r];

        int currentValue = 1;
        res[0] = currentValue;

        for(int coloum = 1; coloum < r; coloum++) {

            currentValue = currentValue * (r - coloum);
            currentValue = currentValue / coloum;

            res[coloum] = currentValue;
        }

        return res;
    }
}
