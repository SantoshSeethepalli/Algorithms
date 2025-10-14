package com.DSA.TUF.Arrays.module_3.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingle_One {

    public int pascalsTriangleI(int r, int c) {

        if(c > r) return 0;

        List<Integer> rThRow = new ArrayList<>();

        int currentValue = 1;
        rThRow.add(1);

        for(int coloum = 1; coloum < r; coloum++) {

            currentValue = currentValue * (r - coloum);
            currentValue = currentValue / coloum;

            rThRow.add(currentValue);
        }

        return rThRow.get(c - 1);
    }
}